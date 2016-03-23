var AppBar, Divider, DropDownMenu, FlatButton, FontAwesome, IconButton, IconMenu, InkBar, List, ListItem, RaisedButton, React, TotalWagers, WagerOverviews, gm_CQSSC, injectTapEventPlugin, wanfaLine2EleText, wanfaLine2Text, wanfaLine3EleText, wanfaLine3Text, wanfaList;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Divider = require('material-ui/lib/divider');

DropDownMenu = require('material-ui/lib/DropDownMenu');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

FontAwesome = require('react-fontawesome');

IconMenu = require('material-ui/lib/menus/icon-menu');

AppBar = require('material-ui/lib/app-bar');

IconButton = require('material-ui/lib/icon-button');

List = require('material-ui/lib/lists/list');

ListItem = require('material-ui/lib/lists/list-item');

Divider = require('material-ui/lib/divider');

InkBar = require("material-ui/lib/ink-bar");

WagerOverviews = require("./WagerOverviews.js");

TotalWagers = require("./TotalWagers.js");

wanfaList = ['五星 ', '四星 ', '后三码', '前三码', '中三码', '二码 ', '定位胆', '不定胆', '大小单双', '趣味 '];

wanfaLine2Text = ['五星直选', '四星直选', '后三直选', '前三直选', '中三直选', '二星直选', '定位胆', '三星不定胆', '大小单双', '特殊'];

wanfaLine2EleText = [['复式', '单式', '组合'], ['复式', '单式', '组合'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['复式', '单式', '直选和值'], ['前二直选(复式)', '前二直选(单式)', '前二直选和值', '后二直选(复式)', '后二直选(单式)', '后二直选和值'], ['定位胆'], ['后三一码不定胆', '后三二码不定胆', '前三一码不定胆', '前三二码不定胆'], ['前大小单双', '后大小单双'], ['一帆风顺', '好事成双', '三星报喜', '四季发财']];

wanfaLine3Text = ['五星组选', '四星组选', '后三组选', '前三组选', '中三组选', '二星组选'];

wanfaLine3EleText = [['组选120', '组选60', '组选30', '组选20', '组选10', '组选5'], ['组选24', '组选12', '组选6', '组选4'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['组三', '组六', '混合组选', '组选和值'], ['前二组选(复式)', '前二组选(单式)', '前二组选和值', '后二组选(复式)', '后二组选(单式)', '后二组选和值']];

gm_CQSSC = React.createClass({
  getInitialState: function() {
    return {
      wanfa: 0,
      wanfaLine2: 0,
      wanfaLine3: -1,
      gameIndex: 0,
      username: '张三'
    };
  },
  handleChangeWanfa: function(e, item, v) {
    console.log("changeSlide:" + e.currentTarget.dataset.id);
    return this.setState({
      wanfa: e.currentTarget.dataset.id,
      wanfaLine2: 0,
      wanfaLine3: -1
    });
  },
  handleMoneyTypeChange: function(e) {
    return console.log("change money:" + e);
  },
  handleChangeWanfaLine2: function(e, item, v) {
    console.log("handleChangeWanfaLine2:" + e.currentTarget.dataset.id);
    return this.setState({
      wanfaLine2: e.currentTarget.dataset.id,
      wanfaLine3: -1
    });
  },
  handleChangeWanfaLine3: function(e, item, v) {
    console.log("handleChangeWanfaLine3:" + e.currentTarget.dataset.id);
    return this.setState({
      wanfaLine2: -1,
      wanfaLine3: e.currentTarget.dataset.id
    });
  },
  handleRefreshUserTitle: function(event, index, value) {
    return console.log("handleChangeGame:index=" + index + ",value=" + value);
  },
  handleClickDropDown: function(e, item) {
    return console.log("downlistgame" + item.props.value);
  },
  genitem: function(text, index) {
    return React.createElement(MenuItem, {
      "value": index,
      "primaryText": text
    });
  },
  render: function() {
    var ballFuncOneLine, ballLines, ballOneLine, index, inkBarStyle, styles, text, wanfaLine2Element, wanfaLine3, wanfaLine3Element, wanfaListElement;
    styles = {
      wanfa: {
        fontSize: "14px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "36px"
      },
      bar: {
        backgroundColor: "white",
        boxShadow: "0",
        minHeight: "48px"
      },
      btn: {
        minWidth: "40px"
      },
      title: {
        fontSize: "14px",
        lineHeight: "32px",
        height: "36px"
      },
      wanfaLine2: {
        fontSize: "14px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "32px"
      },
      btnLine: {
        minWidth: "50px"
      },
      wfbtnselected: {
        backgroundColor: "#FF5722",
        color: "white",
        minWidth: "36px"
      },
      balltitle: {
        backgroundColor: "#424242",
        marginLeft: "5px",
        marginRight: "0px",
        minWidth: "32px",
        lineHeight: "32px",
        fontSize: "14px",
        color: "white"
      },
      balltext: {
        fontSize: "18px",
        paddingLeft: "10px",
        paddingRight: "10px",
        lineHeight: "32px"
      },
      ball: {
        backgroundColor: "#E0E0E0",
        minWidth: "24px",
        marginLeft: "5px",
        marginRight: "0px",
        lineHeight: "32px"
      },
      ballfunctitle: {
        backgroundColor: "#E0E0E0",
        marginLeft: "5px",
        marginRight: "5px",
        minWidth: "24px",
        fontSize: "12px",
        paddingLeft: "2px",
        paddingRight: "2px"
      },
      ballfunc: {
        backgroundColor: "#E0E0E0",
        marginLeft: "2px",
        marginRight: "2px",
        lineHeight: "24px",
        minWidth: "24px"
      }
    };
    inkBarStyle = {};
    wanfaListElement = (function() {
      var i, len, results;
      results = [];
      for (index = i = 0, len = wanfaList.length; i < len; index = ++i) {
        text = wanfaList[index];
        results.push(React.createElement("div", null, React.createElement(FlatButton, {
          "ref": "wf_" + index,
          "label": text,
          "primary": (index + "" === this.state.wanfa + "" ? true : false),
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfa,
          "labelStyle": styles.wanfa,
          "style": styles.btn
        }), React.createElement("div", {
          "className": "vdivider"
        })));
      }
      return results;
    }).call(this);
    wanfaLine2Element = (function() {
      var i, len, ref, results;
      ref = wanfaLine2EleText[this.state.wanfa];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_1_" + index,
          "label": text,
          "style": (index + "" === this.state.wanfaLine2 + "" ? styles.wfbtnselected : styles.btn),
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfaLine2,
          "labelStyle": styles.wanfaLine2
        }));
      }
      return results;
    }).call(this);
    wanfaLine3 = (this.state.wanfa < wanfaLine3EleText.length ? (wanfaLine3Element = (function() {
      var i, len, ref, results;
      ref = wanfaLine3EleText[this.state.wanfa];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_2_" + index,
          "label": text,
          "style": (index + "" === this.state.wanfaLine3 + "" ? styles.wfbtnselected : styles.btn),
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleChangeWanfaLine3,
          "labelStyle": styles.wanfaLine2
        }));
      }
      return results;
    }).call(this), React.createElement("div", {
      "className": "row wanfaLine"
    }, React.createElement("span", null, wanfaLine3Text[this.state.wanfa], ":"), " ", wanfaLine3Element)) : React.createElement("div", {
      "className": "clearfix"
    }));
    ballOneLine = (function() {
      var i, results;
      results = [];
      for (index = i = 0; i <= 9; index = ++i) {
        results.push(React.createElement(FlatButton, {
          "ref": "wf_" + index,
          "label": "" + index,
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleClickBall,
          "labelStyle": styles.balltext,
          "style": styles.ball
        }));
      }
      return results;
    }).call(this);
    ballFuncOneLine = (function() {
      var i, len, ref, results;
      ref = ['全', '大', '小', '奇', '偶', '清'];
      results = [];
      for (index = i = 0, len = ref.length; i < len; index = ++i) {
        text = ref[index];
        results.push(React.createElement(FlatButton, {
          "ref": "wf_f_" + index,
          "label": text,
          "key": index,
          "data-id": index,
          "onTouchTap": this.handleClickBall,
          "labelStyle": styles.ballfunctitle,
          "style": styles.ballfunc
        }));
      }
      return results;
    }).call(this);
    ballLines = React.createElement("div", null, React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": "万位",
      "style": styles.balltitle,
      "key": index,
      "labelStyle": styles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine)), React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": "千位",
      "style": styles.balltitle,
      "key": index,
      "labelStyle": styles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine)), React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": "百位",
      "style": styles.balltitle,
      "key": index,
      "labelStyle": styles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine)), React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": "十位",
      "style": styles.balltitle,
      "key": index,
      "labelStyle": styles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine)), React.createElement("div", {
      "className": "row ballLine  col-sm-12"
    }, React.createElement("div", {
      "className": "col-sm-8"
    }, " ", React.createElement(FlatButton, {
      "label": "个位",
      "style": styles.balltitle,
      "key": index,
      "labelStyle": styles.wanfaLine2
    }), ballOneLine, " "), React.createElement("div", {
      "className": "col-sm-4 divctl"
    }, ballFuncOneLine)));
    return React.createElement("div", {
      "className": "container"
    }, React.createElement("div", {
      "className": "row"
    }, React.createElement("div", {
      "className": "col-md-9"
    }, React.createElement("div", {
      "className": "gamearea"
    }, React.createElement("div", {
      "className": "row"
    }, wanfaListElement), React.createElement(Divider, null), React.createElement("div", {
      "className": "row wanfaLine "
    }, React.createElement("span", null, wanfaLine2Text[this.state.wanfa], ":"), " ", wanfaLine2Element), wanfaLine3, React.createElement(Divider, null), React.createElement("div", {
      "className": "row ballLine"
    }, ballLines), React.createElement("div", {
      "className": "row wagerarea"
    }, React.createElement(WagerOverviews, null), React.createElement(TotalWagers, null)), React.createElement(Divider, null))), React.createElement("div", {
      "className": "col-md-3"
    }, React.createElement("div", {
      "className": "row"
    }, "游戏状态"))));
  }
});

module.exports = gm_CQSSC;
