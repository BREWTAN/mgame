React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");
ReactDOM = require("react-dom")

Tabs  = require("material-ui/lib/tabs/tabs");
Tab  = require("material-ui/lib/tabs/tab");
# From https://github.com/oliviertassinari/react-swipeable-views

DropDownMenu  = require( 'material-ui/lib/DropDownMenu');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
FlatButton = require('material-ui/lib/flat-button');
FontAwesome = require('react-fontawesome');
IconMenu = require('material-ui/lib/menus/icon-menu');
UserMenu = require('./UserMenu.js');
GameTexts = ["重庆时时彩","日本时时彩","双色球","大乐透"]
InkBar  = require("material-ui/lib/ink-bar");

GameMenu = React.createClass(

    getInitialState:() ->
        slideIndex: 0,
        gameIndex: 0

    handleChangeSlide:(e,item,v) ->
        console.log("changeSlide:"+e.currentTarget.dataset.id)
        @setState
           slideIndex: e.currentTarget.dataset.id

    handleChangeGame:(event, index, value) ->
        console.log("handleChangeGame:index="+index+",value="+value)
        @setState
            gameIndex: value

    handleClickDropDown:(e,item) ->
        console.log("downlistgame"+item.props.value)
        @setState
            gameIndex: item.props.value


    genitem:(text,index) ->
        return <MenuItem value={index} key={index} primaryText={text} />

    render:() ->
        styles = {
          slide: {
            fontSize: "16px",
            color:"white",
            paddingLeft:"0px",
            paddingRight:"3px",
            lineHeight:"48px",
            width:"16%"
          },
          slide1: {
              fontSize: "18px",
              color:"white",
              paddingLeft:"0px",
              paddingRight:"3px",
              lineHeight:"48px",
              width:"16%"
          },
          btn:{
            lineHeight:"48px",
            width:"100%"
          },
          btn1:{
            lineHeight:"48px",


          }
        };
        inkBarStyle={

        }
        width = if @state.slideIndex > 0 then 16 else 20;

        offset = if (@state.slideIndex > 0) then ((20+(@state.slideIndex-1)*16)) else 0;

        #console.log("offset=="+offset+",slideIndex="+@state.slideIndex)
        gamelistmenu=<IconMenu　onItemTouchTap={@handleClickDropDown}
                           iconButtonElement={<FontAwesome name='caret-down' className='fa-lg fa-inverse' />}
                            anchorOrigin={{horizontal: 'left', vertical: 'top'}}
                           targetOrigin={{horizontal: 'left', vertical: 'top'}}
                         >
                        {@genitem(text,index) for text, index in GameTexts}
                    </IconMenu>
        return (
         <div>
            <div className ="menubar">
                <nav className="navbar navbar-inverse container">
                  <div className="container-fluid">
                    <ul className="nav navbar-nav">
                      <li className="active"><center><FlatButton  data-id={0} onTouchTap={@handleChangeSlide} label={GameTexts[@state.gameIndex]} labelStyle={styles.slide1} style={styles.btn1} className="menubar-tabs" />{gamelistmenu}</center></li>
                      <li><FlatButton label="账户管理" data-id={1} onTouchTap={@handleChangeSlide} labelStyle={styles.slide} style={styles.btn} className="menubar-tabs" /></li>
                      <li><FlatButton label="投注查询" data-id={2}  onTouchTap={@handleChangeSlide} labelStyle={styles.slide} style={styles.btn} className="menubar-tabs" /></li>
                      <li><FlatButton label="报表查询" data-id={3} onTouchTap={@handleChangeSlide} labelStyle={styles.slide} style={styles.btn} className="menubar-tabs" /></li>
                      <li><FlatButton label="网站公告" data-id={4}  onTouchTap={@handleChangeSlide} labelStyle={styles.slide} style={styles.btn} className="menubar-tabs" /></li>
                      <li><FlatButton label="新手帮助" data-id={5}  onTouchTap={@handleChangeSlide} labelStyle={styles.slide} style={styles.btn} className="menubar-tabs" /></li>
                    </ul>
                  </div>
                  <InkBar
                          left={offset + '%'}
                          width={width + '%'}
                          style={inkBarStyle}
                  />
                </nav>

            </div>
            <div>
                <UserMenu />
            </div>
         </div>
        );
)


module.exports = GameMenu
#ReactDOM.render <UserMenu/>, document.getElementById("usermenu")

