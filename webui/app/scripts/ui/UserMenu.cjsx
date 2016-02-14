React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Tabs  = require("material-ui/lib/tabs/tabs");
Tab  = require("material-ui/lib/tabs/tab");
# From https://github.com/oliviertassinari/react-swipeable-views

DropDownMenu  = require( 'material-ui/lib/DropDownMenu');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
FlatButton = require('material-ui/lib/flat-button');
FontAwesome = require('react-fontawesome');
IconMenu = require('material-ui/lib/menus/icon-menu');


GameTexts = ["重庆时时彩","日本时时彩","双色球","大乐透"]


GameMenu = React.createClass(

    getInitialState:() ->
        slideIndex: 0,
        gameIndex: 0

    handleChangeTab:(vv) ->
        console.log("changetab:"+vv)
        @setState
            slideIndex: vv
    handleChangeGame:(event, index, value) ->
        console.log("handleChangeGame:index="+index+",value="+value)
        @setState
            gameIndex: value

    handleClickDropDown:(e,item) ->
        console.log("downlistgame"+item.props.value)

    genitem:(text,index) ->
        return <MenuItem value={index} primaryText={text} />

    render:() ->
        styles = {
          slide: {
            fontSize: "18px",
            color:"white",
            paddingLeft:"0px",
            paddingRight:"3px"
          },
          slide1: {
            background: '#FEA900',
          },
          slide2: {
            background: '#B3DC4A',
          },
          slide3: {
            background: '#6AC0FF',
          },
        };
        gamelistmenu=<IconMenu　onItemTouchTap={@handleClickDropDown}
                           iconButtonElement={<FontAwesome name='caret-down' className='fa-lg fa-inverse' />}
                           anchorOrigin={{horizontal: 'left', vertical: 'top'}}
                           targetOrigin={{horizontal: 'left', vertical: 'top'}}
                         >
                        {@genitem(text,index) for text, index in GameTexts}
                    </IconMenu>
        return (

         <div className ="menubar">
               <Tabs
                 style={styles.slide}
                 className="container"
                 onChange={@handleChangeTab}
                 value={@state.slideIndex}
               >
                    <Tab label={<div><FlatButton label={GameTexts[@state.gameIndex]} labelStyle={styles.slide} className="menubar-tabs" />{gamelistmenu} </div>} value={0} className = "menubar-tabs" style={styles.slide}>

                    </Tab>

                    <Tab label="账户管理" value={1} className = "menubar-tabs" style={styles.slide}/>
                    <Tab label="投注查询" value={2} className = "menubar-tabs" style={styles.slide}/>
                    <Tab label="报表查询" value={3} className = "menubar-tabs" style={styles.slide}/>
                    <Tab label="网站公告" value={4} className = "menubar-tabs" style={styles.slide}/>
                    <Tab label="新手帮助" value={5} className = "menubar-tabs" style={styles.slide}/>

               </Tabs>


         </div>
        );
)

module.exports = GameMenu

