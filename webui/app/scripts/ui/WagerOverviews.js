var MenuItem, RaisedButton, React, SelectField, TextField, WagerOverviews, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

SelectField = require('material-ui/lib/select-field');

MenuItem = require('material-ui/lib/menus/menu-item');

TextField = require('material-ui/lib/text-field');

RaisedButton = require('material-ui/lib/raised-button');

WagerOverviews = React.createClass({
  getInitialState: function() {
    return {
      totalMoney: 1,
      moneyType: 1,
      multi: 1
    };
  },
  handleWagerOChange: function(e) {
    return this.setState({
      multi: e.target.value,
      totalMoney: e.target.value * this.state.moneyType
    });
  },
  handleWagerSelChange: function(e) {
    return this.setState({
      moneyType: parseFloat(e.currentTarget.dataset.v),
      totalMoney: this.state.multi * e.currentTarget.dataset.v
    });
  },
  render: function() {
    var styles;
    styles = {
      moneySel: {
        color: "black",
        fontSize: "13px",
        width: "48px",
        lineHeight: "24px",
        height: "24px",
        zIndex: "2",
        marginTop: "-20px"
      },
      moneySelLabel: {
        lineHeight: "24px",
        color: "red",
        top: "0px",
        height: "24px"
      },
      moneyIcon: {
        lineHeight: "24px",
        height: "24px",
        backgroundColor: "#F2DEDE",
        fill: "black",
        marginTop: "-14px"
      },
      moneyUnderLine: {
        backgroundColor: "black",
        display: "none",
        marginTop: "-12px"
      },
      confirmbtn: {
        float: "right"
      }
    };
    console.log("render:wagerOverviews");
    return React.createElement("div", {
      "className": "wagersum col-sm-12"
    }, React.createElement("div", {
      "className": "row col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-3"
    }, "您共选择了 ", React.createElement("b", null, "0"), " 注  "), React.createElement("div", {
      "className": "col-sm-3"
    }, " 投注模式为 ", React.createElement("div", {
      "className": "sel"
    }), " ", React.createElement("b", null, React.createElement(SelectField, {
      "value": this.state.moneyType,
      "style": styles.moneySel,
      "labelStyle": styles.moneySelLabel,
      "iconStyle": styles.moneyIcon,
      "underlineStyle": styles.moneyUnderLine,
      "onChange": this.handleWagerSelChange
    }, React.createElement(MenuItem, {
      "data-v": 1.,
      "value": 1.,
      "primaryText": "元"
    }), React.createElement(MenuItem, {
      "data-v": 0.1,
      "value": 0.1,
      "primaryText": "角"
    }), React.createElement(MenuItem, {
      "data-v": 0.01,
      "value": 0.01,
      "primaryText": "分"
    }), React.createElement(MenuItem, {
      "data-v": 0.001,
      "value": 0.001,
      "primaryText": "厘"
    })), React.createElement("div", {
      "className": "selectbg"
    }))), React.createElement("div", {
      "className": "col-sm-3"
    }, React.createElement("div", {
      "className": "vdivider"
    }), "投注倍数为  ", React.createElement("b", null, React.createElement("input", {
      "id": "multi",
      "value": this.state.multi,
      "size": 3,
      "onChange": this.handleWagerOChange
    })), " 倍"), React.createElement("div", {
      "className": "col-sm-3"
    }, "共 ", React.createElement("b", {
      "id": "money_total"
    }, this.state.totalMoney), " 元")), React.createElement("div", {
      "className": "row col-sm-12"
    }, React.createElement(RaisedButton, {
      "label": "确认选号",
      "style": styles.confirmbtn,
      "primary": true,
      "onTouchTap": this.handleOpen
    })));
  }
});

module.exports = WagerOverviews;
