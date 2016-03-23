React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views


SelectField  = require( 'material-ui/lib/select-field');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
TextField = require( 'material-ui/lib/text-field' );
RaisedButton = require('material-ui/lib/raised-button');

List = require('material-ui/lib/lists/list');
ListItem = require('material-ui/lib/lists/list-item');
Checkbox  = require('material-ui/lib/checkbox');

TotalWagers = React.createClass(

    getInitialState:() ->
        zhuihao: false
        totalWagerCount: 1
        totalWagerMoney: 1000

    handleClickZhuihao:(e) ->
        console.log("handleClickZhuihao:"+e.currentTarget.value)
        @setState
            zhuihao: !@state.zhuihao

    handleClickZhuihaoStop:(e) ->
        console.log("handleClickZhuihaoStop:"+e.currentTarget.checked)


    render:() ->
        styles = {
            listcs:{
                width:"100%"
                color:"whiteSmoke",
                fontSize:"13px",
                padding:"0px 0px 0px 23px",

            }
            checkbox:{
                width:"16px"
                height:"16px"
                fill:"whiteSmoke"
                top:"-16px"
                left:"5px"
            }
            checkboxi:{
                width:"16px"
                fill:"whiteSmoke"
            }

            confirmbtn:{
                float:"right"
                height:"36px"
            }
        };
        return (
         <div className="wagertotal col-sm-12">
             <div className="col-sm-9">您已确认 <b>{@state.totalWagerCount}</b> 注, 总金额 <b id="money_total">{@state.totalMoney}</b> 元

                 <ListItem style={styles.listcs}

                          leftCheckbox={<Checkbox checked={@state.zhuihao} onCheck={@handleClickZhuihao} style={styles.checkbox} iconStyle={styles.checkboxi} />}
                          primaryText="发起追号"
                        />
                 <ListItem style={styles.listcs}
                          leftCheckbox={<Checkbox disabled={!@state.zhuihao} onCheck={@handleClickZhuihaoStop}   style={styles.checkbox} iconStyle={styles.checkboxi} />}
                          primaryText="中奖后停止追号"
                        />
             </div>

             <div className="row col-sm-3">
                  <RaisedButton label="提交注单" style={styles.confirmbtn}
                    primary={true} onTouchTap={this.handleOpen}/>
             </div>
          </div>
        );
)

module.exports = TotalWagers

