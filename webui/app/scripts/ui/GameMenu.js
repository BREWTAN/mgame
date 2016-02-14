var DropDownMenu, FlatButton, FontAwesome, GameMenu, GameTexts, IconMenu, InkBar, MenuItem, React, ReactDOM, Tab, Tabs, UserMenu, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

ReactDOM = require("react-dom");

Tabs = require("material-ui/lib/tabs/tabs");

Tab = require("material-ui/lib/tabs/tab");

DropDownMenu = require('material-ui/lib/DropDownMenu');

MenuItem = require('material-ui/lib/menus/menu-item');

FlatButton = require('material-ui/lib/flat-button');

FontAwesome = require('react-fontawesome');

IconMenu = require('material-ui/lib/menus/icon-menu');

UserMenu = require('./UserMenu.js');

GameTexts = ["重庆时时彩", "日本时时彩", "双色球", "大乐透"];

InkBar = require("material-ui/lib/ink-bar");

GameMenu = React.createClass({
  getInitialState: function() {
    return {
      slideIndex: 0,
      gameIndex: 0
    };
  },
  handleChangeSlide: function(e, item, v) {
    console.log("changeSlide:" + e.currentTarget.dataset.id);
    return this.setState({
      slideIndex: e.currentTarget.dataset.id
    });
  },
  handleChangeGame: function(event, index, value) {
    console.log("handleChangeGame:index=" + index + ",value=" + value);
    return this.setState({
      gameIndex: value
    });
  },
  handleClickDropDown: function(e, item) {
    console.log("downlistgame" + item.props.value);
    return this.setState({
      gameIndex: item.props.value
    });
  },
  genitem: function(text, index) {
    return React.createElement(MenuItem, {
      "value": index,
      "key": index,
      "primaryText": text
    });
  },
  render: function() {
    var gamelistmenu, index, inkBarStyle, offset, styles, text, width;
    styles = {
      slide: {
        fontSize: "16px",
        color: "white",
        paddingLeft: "0px",
        paddingRight: "3px",
        lineHeight: "48px",
        width: "16%"
      },
      slide1: {
        fontSize: "18px",
        color: "white",
        paddingLeft: "0px",
        paddingRight: "3px",
        lineHeight: "48px",
        width: "16%"
      },
      btn: {
        lineHeight: "48px",
        width: "100%"
      },
      btn1: {
        lineHeight: "48px"
      }
    };
    inkBarStyle = {};
    width = this.state.slideIndex > 0 ? 16 : 20;
    offset = this.state.slideIndex > 0 ? 20 + (this.state.slideIndex - 1) * 16 : 0;
    gamelistmenu = React.createElement(IconMenu, {
      "onItemTouchTap": this.handleClickDropDown,
      "iconButtonElement": React.createElement(FontAwesome, {
        "name": 'caret-down',
        "className": 'fa-lg fa-inverse'
      }),
      "anchorOrigin": {
        horizontal: 'left',
        vertical: 'top'
      },
      "targetOrigin": {
        horizontal: 'left',
        vertical: 'top'
      }
    }, (function() {
      var i, len, results;
      results = [];
      for (index = i = 0, len = GameTexts.length; i < len; index = ++i) {
        text = GameTexts[index];
        results.push(this.genitem(text, index));
      }
      return results;
    }).call(this));
    return React.createElement("div", null, React.createElement("div", {
      "className": "menubar"
    }, React.createElement("nav", {
      "className": "navbar navbar-inverse container"
    }, React.createElement("div", {
      "className": "container-fluid"
    }, React.createElement("ul", {
      "className": "nav navbar-nav"
    }, React.createElement("li", {
      "className": "active"
    }, React.createElement("center", null, React.createElement(FlatButton, {
      "data-id": 0.,
      "onTouchTap": this.handleChangeSlide,
      "label": GameTexts[this.state.gameIndex],
      "labelStyle": styles.slide1,
      "style": styles.btn1,
      "className": "menubar-tabs"
    }), gamelistmenu)), React.createElement("li", null, React.createElement(FlatButton, {
      "label": "账户管理",
      "data-id": 1.,
      "onTouchTap": this.handleChangeSlide,
      "labelStyle": styles.slide,
      "style": styles.btn,
      "className": "menubar-tabs"
    })), React.createElement("li", null, React.createElement(FlatButton, {
      "label": "投注查询",
      "data-id": 2.,
      "onTouchTap": this.handleChangeSlide,
      "labelStyle": styles.slide,
      "style": styles.btn,
      "className": "menubar-tabs"
    })), React.createElement("li", null, React.createElement(FlatButton, {
      "label": "报表查询",
      "data-id": 3.,
      "onTouchTap": this.handleChangeSlide,
      "labelStyle": styles.slide,
      "style": styles.btn,
      "className": "menubar-tabs"
    })), React.createElement("li", null, React.createElement(FlatButton, {
      "label": "网站公告",
      "data-id": 4.,
      "onTouchTap": this.handleChangeSlide,
      "labelStyle": styles.slide,
      "style": styles.btn,
      "className": "menubar-tabs"
    })), React.createElement("li", null, React.createElement(FlatButton, {
      "label": "新手帮助",
      "data-id": 5.,
      "onTouchTap": this.handleChangeSlide,
      "labelStyle": styles.slide,
      "style": styles.btn,
      "className": "menubar-tabs"
    })))), React.createElement(InkBar, {
      "left": offset + '%',
      "width": width + '%',
      "style": inkBarStyle
    }))), React.createElement("div", null, React.createElement(UserMenu, null)));
  }
});

module.exports = GameMenu;
