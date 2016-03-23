React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");


# From https://github.com/oliviertassinari/react-swipeable-views
Divider = require( 'material-ui/lib/divider');

DropDownMenu  = require( 'material-ui/lib/DropDownMenu');
FlatButton = require('material-ui/lib/flat-button');
RaisedButton = require('material-ui/lib/raised-button');

FontAwesome = require('react-fontawesome');
IconMenu = require('material-ui/lib/menus/icon-menu');
AppBar = require('material-ui/lib/app-bar');
IconButton =require('material-ui/lib/icon-button');

List =require( 'material-ui/lib/lists/list');
ListItem =require( 'material-ui/lib/lists/list-item');
Divider =require( 'material-ui/lib/divider');

InkBar  = require("material-ui/lib/ink-bar");

WagerOverviews  = require("./WagerOverviews.js");
TotalWagers = require("./TotalWagers.js")

wanfaList = ['五星 ','四星 ','后三码','前三码','中三码','二码 ','定位胆','不定胆','大小单双','趣味 '];

wanfaLine2Text = ['五星直选','四星直选','后三直选','前三直选','中三直选','二星直选','定位胆','三星不定胆','大小单双','特殊'];
wanfaLine2EleText=[['复式','单式','组合'],
                ['复式','单式','组合'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['复式','单式','直选和值'],
                ['前二直选(复式)','前二直选(单式)','前二直选和值','后二直选(复式)','后二直选(单式)','后二直选和值'],
                ['定位胆'],
                ['后三一码不定胆','后三二码不定胆','前三一码不定胆','前三二码不定胆'],
                ['前大小单双','后大小单双']
                ['一帆风顺','好事成双','三星报喜','四季发财']
              ]
wanfaLine3Text = ['五星组选','四星组选','后三组选','前三组选','中三组选','二星组选'];
wanfaLine3EleText = [['组选120','组选60','组选30','组选20','组选10','组选5'],#5
                ['组选24','组选12','组选6','组选4'],
                ['组三','组六','混合组选','组选和值'],
                ['组三','组六','混合组选','组选和值'],
                ['组三','组六','混合组选','组选和值'],
                ['前二组选(复式)','前二组选(单式)','前二组选和值','后二组选(复式)','后二组选(单式)','后二组选和值'],
              ];

gm_CQSSC = React.createClass(

    getInitialState:() ->
        wanfa:0
        wanfaLine2:0
        wanfaLine3: -1
        gameIndex: 0,
        username:'张三'


    handleChangeWanfa:(e,item,v) ->
         console.log("changeSlide:"+e.currentTarget.dataset.id)
         @setState
            wanfa:e.currentTarget.dataset.id
            wanfaLine2:0
            wanfaLine3: -1

    handleMoneyTypeChange:(e) ->
        console.log("change money:"+e)

    handleChangeWanfaLine2:(e,item,v) ->
        console.log("handleChangeWanfaLine2:"+e.currentTarget.dataset.id)
        @setState
           wanfaLine2:e.currentTarget.dataset.id
           wanfaLine3: -1
    handleChangeWanfaLine3:(e,item,v) ->
        console.log("handleChangeWanfaLine3:"+e.currentTarget.dataset.id)
        @setState
           wanfaLine2:-1
           wanfaLine3:e.currentTarget.dataset.id

    handleRefreshUserTitle:(event, index, value) ->
        console.log("handleChangeGame:index="+index+",value="+value)


    handleClickDropDown:(e,item) ->
        console.log("downlistgame"+item.props.value)

    genitem:(text,index) ->
        return <MenuItem value={index} primaryText={text} />

    render:() ->
        styles = {
          wanfa: {
              fontSize: "14px",
              paddingLeft:"10px",
              paddingRight:"10px",
              lineHeight:"36px",
            },
          bar: {
            backgroundColor:"white",
            boxShadow:"0",
            minHeight:"48px",
          },

          btn:{
           minWidth:"40px"
          }
          title: {
            fontSize: "14px",
            lineHeight:"32px",
            height:"36px"
          },
          wanfaLine2: {
              fontSize: "14px",
              paddingLeft:"10px",
              paddingRight:"10px",
              lineHeight:"32px",
            },
          btnLine:{
             minWidth:"50px"
          },
          wfbtnselected:{
             backgroundColor: "#FF5722"
             color: "white"
             minWidth:"36px"
          },
          balltitle:{
             backgroundColor: "#424242"
             marginLeft:"5px",
             marginRight:"0px",
             minWidth:"32px",
             lineHeight:"32px",
             fontSize: "14px",
             color:"white"
          },
          balltext: {
            fontSize: "18px",
            paddingLeft:"10px",
            paddingRight:"10px",
            lineHeight:"32px",
          },
          ball:{
            backgroundColor: "#E0E0E0"
            minWidth:"24px"
            marginLeft:"5px",
            marginRight:"0px",
            lineHeight:"32px",
            },
          ballfunctitle:{
             backgroundColor: "#E0E0E0"
             marginLeft:"5px",
             marginRight:"5px",
             minWidth:"24px",
             fontSize: "12px",
             paddingLeft:"2px",
             paddingRight:"2px",

          }
          ballfunc:{
            backgroundColor: "#E0E0E0"
            marginLeft:"2px",
            marginRight:"2px",
            lineHeight:"24px",
            minWidth:"24px"
            }


        };
        inkBarStyle={

        }



        wanfaListElement=( <div><FlatButton ref={"wf_"+index} label={text} primary= { if index+"" == @state.wanfa+"" then true else false } key={index} data-id={index} onTouchTap={@handleChangeWanfa} labelStyle={styles.wanfa} style={styles.btn} /><div className="vdivider"></div></div> for text,index in wanfaList )

        wanfaLine2Element = ( <FlatButton ref={"wf_1_"+index} label={text} style= { if index+"" == @state.wanfaLine2+"" then styles.wfbtnselected else styles.btn } key={index} data-id={index} onTouchTap={@handleChangeWanfaLine2} labelStyle={styles.wanfaLine2} /> for text,index in wanfaLine2EleText[@state.wanfa] )

        wanfaLine3 = ( if (@state.wanfa < wanfaLine3EleText.length)
                          wanfaLine3Element = ( <FlatButton ref={"wf_2_"+index} label={text} style= { if index+"" == @state.wanfaLine3+"" then styles.wfbtnselected else styles.btn } key={index} data-id={index} onTouchTap={@handleChangeWanfaLine3} labelStyle={styles.wanfaLine2} /> for text,index in wanfaLine3EleText[@state.wanfa] )
                          <div className="row wanfaLine"><span>{wanfaLine3Text[@state.wanfa]}:</span> {wanfaLine3Element}</div>
                        else
                          <div className="clearfix"></div>
                     )

        ballOneLine = (<FlatButton ref={"wf_"+index} label={""+index} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={styles.balltext} style={styles.ball} /> for index in [0..9] )
        ballFuncOneLine = (<FlatButton ref={"wf_f_"+index} label={text} key={index} data-id={index} onTouchTap={@handleClickBall} labelStyle={styles.ballfunctitle} style={styles.ballfunc} /> for text,index in ['全','大','小','奇','偶','清'] )
        ballLines = (<div>
            <div className="row ballLine  col-sm-12" >
                  <div className="col-sm-8"> <FlatButton label="万位" style={styles.balltitle} key={index} labelStyle={styles.wanfaLine2} />{ballOneLine} </div>
                  <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
            </div>
            <div className="row ballLine  col-sm-12" >
                  <div className="col-sm-8"> <FlatButton label="千位" style={styles.balltitle} key={index} labelStyle={styles.wanfaLine2} />{ballOneLine} </div>
                  <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
            </div>
            <div className="row ballLine  col-sm-12" >
                  <div className="col-sm-8"> <FlatButton label="百位" style={styles.balltitle} key={index} labelStyle={styles.wanfaLine2} />{ballOneLine} </div>
                  <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
            </div>
            <div className="row ballLine  col-sm-12" >
                  <div className="col-sm-8"> <FlatButton label="十位" style={styles.balltitle} key={index} labelStyle={styles.wanfaLine2} />{ballOneLine} </div>
                  <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
            </div>
            <div className="row ballLine  col-sm-12" >
                  <div className="col-sm-8"> <FlatButton label="个位" style={styles.balltitle} key={index} labelStyle={styles.wanfaLine2} />{ballOneLine} </div>
                  <div className="col-sm-4 divctl">{ballFuncOneLine}</div>
            </div>
            </div>
        )
        return (
            <div className="container">
            <div className="row">
            <div className="col-md-9">
                <div className="gamearea">
                    <div className="row">
                        {wanfaListElement}
                    </div>
                    <Divider />
                    <div className="row wanfaLine " >
                       <span>{wanfaLine2Text[@state.wanfa]}:</span> {wanfaLine2Element}
                    </div>
                     {wanfaLine3}
                    <Divider />
                    <div className="row ballLine" >
                          {ballLines}
                    </div>
                    <div className="row wagerarea">
                        <WagerOverviews />
                        <TotalWagers />

                    </div>

                    <Divider />


                </div>
            </div>
            <div className="col-md-3">
                <div className="row">
                    游戏状态
                </div>
            </div>
            </div>
            </div>
        );
)

module.exports = gm_CQSSC

