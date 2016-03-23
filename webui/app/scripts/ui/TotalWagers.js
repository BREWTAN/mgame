var Checkbox, List, ListItem, MenuItem, RaisedButton, React, SelectField, TextField, TotalWagers, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

SelectField = require('material-ui/lib/select-field');

MenuItem = require('material-ui/lib/menus/menu-item');

TextField = require('material-ui/lib/text-field');

RaisedButton = require('material-ui/lib/raised-button');

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

Checkbox = require('material-ui/lib/checkbox');

TotalWagers = React.createClass({
  getInitialState: function() {
    return {
      zhuihao: false,
      totalWagerCount: 1,
      totalWagerMoney: 1000
    };
  },
  handleClickZhuihao: function(e) {
    console.log("handleClickZhuihao:" + e.currentTarget.value);
    return this.setState({
      zhuihao: !this.state.zhuihao
    });
  },
  handleClickZhuihaoStop: function(e) {
    return console.log("handleClickZhuihaoStop:" + e.currentTarget.checked);
  },
  render: function() {
    var styles;
    styles = {
      listcs: {
        width: "100%",
        color: "whiteSmoke",
        fontSize: "13px",
        padding: "0px 0px 0px 23px"
      },
      checkbox: {
        width: "16px",
        height: "16px",
        fill: "whiteSmoke",
        top: "-16px",
        left: "5px"
      },
      checkboxi: {
        width: "16px",
        fill: "whiteSmoke"
      },
      confirmbtn: {
        float: "right",
        height: "36px"
      }
    };
    return React.createElement("div", {
      "className": "wagertotal col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-9"
    }, "您已确认 ", React.createElement("b", null, this.state.totalWagerCount), " 注, 总金额 ", React.createElement("b", {
      "id": "money_total"
    }, this.state.totalMoney), " 元\n", React.createElement(ListItem, {
      "style": styles.listcs,
      "leftCheckbox": React.createElement(Checkbox, {
        "checked": this.state.zhuihao,
        "onCheck": this.handleClickZhuihao,
        "style": styles.checkbox,
        "iconStyle": styles.checkboxi
      }),
      "primaryText": "发起追号"
    }), React.createElement(ListItem, {
      "style": styles.listcs,
      "leftCheckbox": React.createElement(Checkbox, {
        "disabled": !this.state.zhuihao,
        "onCheck": this.handleClickZhuihaoStop,
        "style": styles.checkbox,
        "iconStyle": styles.checkboxi
      }),
      "primaryText": "中奖后停止追号"
    })), React.createElement("div", {
      "className": "row col-sm-3"
    }, React.createElement(RaisedButton, {
      "label": "提交注单",
      "style": styles.confirmbtn,
      "primary": true,
      "onTouchTap": this.handleOpen
    })));
  }
});

module.exports = TotalWagers;
