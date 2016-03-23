React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

# From https://github.com/oliviertassinari/react-swipeable-views


SelectField  = require( 'material-ui/lib/select-field');
MenuItem  = require( 'material-ui/lib/menus/menu-item');
TextField = require( 'material-ui/lib/text-field' );
RaisedButton = require('material-ui/lib/raised-button');

WagerOverviews = React.createClass(

    getInitialState:() ->
        totalMoney: 1
        moneyType: 1
        multi:1

    handleWagerOChange:(e) ->
        #console.log("changeWagerInfo:"+e.target.value)

        @setState
            multi: e.target.value
            totalMoney: e.target.value*@state.moneyType

    handleWagerSelChange:(e) ->
        #console.log("handleWagerSelChange:"+e.currentTarget.dataset.v)
        @setState
            moneyType: parseFloat(e.currentTarget.dataset.v)
            totalMoney: @state.multi*e.currentTarget.dataset.v

    render:() ->
        styles = {
         moneySel:{
             color:"black",
             fontSize:"13px",
             width:"48px",
             lineHeight:"24px",
             height:"24px",
             zIndex:"2"
             marginTop:"-20px"

         },
        moneySelLabel:{
            lineHeight:"24px",
            color:"red",
            top:"0px",
            height:"24px",
        }
        moneyIcon:{
          lineHeight:"24px",
          height:"24px",
          backgroundColor:"#F2DEDE",
          fill:"black",
          marginTop:"-14px"

        }
        moneyUnderLine:{
          backgroundColor:"black",
          display:"none"
          marginTop:"-12px"
        },
        confirmbtn:{
            float:"right"
        }
        };
        console.log("render:wagerOverviews")
        return (

         <div className="wagersum col-sm-12">
             <div className="row col-sm-12">
                 <div className="col-sm-3">您共选择了 <b>0</b> 注  </div>
                 <div className="col-sm-3"> 投注模式为 <div className="sel"/> <b>
                 <SelectField value={@state.moneyType} style={styles.moneySel}
                         labelStyle={styles.moneySelLabel}
                         iconStyle={styles.moneyIcon}
                         underlineStyle={styles.moneyUnderLine}
                         onChange={@handleWagerSelChange}>
                                     <MenuItem data-v={1} value={1} primaryText="元"/>
                                     <MenuItem data-v={0.1} value={0.1}  primaryText="角"/>
                                     <MenuItem data-v={0.01} value={0.01}  primaryText="分"/>
                                     <MenuItem data-v={0.001} value={0.001}  primaryText="厘"/>
                     </SelectField><div className="selectbg" ></div></b>
                 </div>
                 <div className="col-sm-3">

                        <div className="vdivider" />投注倍数为  <b><input id="multi" value={@state.multi}
                                     size=3 onChange={@handleWagerOChange}
                                    /></b> 倍
                </div>
                 <div className="col-sm-3">共 <b id="money_total">{@state.totalMoney}</b> 元
                 </div>
             </div>
             <div className="row col-sm-12">
                  <RaisedButton label="确认选号"  style={styles.confirmbtn}
                    primary={true} onTouchTap={this.handleOpen}/>

             </div>
          </div>
        );
)

module.exports = WagerOverviews

