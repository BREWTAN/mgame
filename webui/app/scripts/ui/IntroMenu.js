var IntroMenu, React, Tab, Tabs, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Tabs = require("material-ui/lib/tabs/tabs");

Tab = require("material-ui/lib/tabs/tab");

IntroMenu = React.createClass({
  getInitialState: function() {
    return {
      slideIndex: 0
    };
  },
  handleChangeTab: function(vv) {
    console.log("changetab:" + vv);
    return this.setState({
      slideIndex: vv
    });
  },
  render: function() {
    var styles;
    styles = {
      slide: {
        fontSize: "18px"
      },
      slide1: {
        background: '#FEA900'
      },
      slide2: {
        background: '#B3DC4A'
      },
      slide3: {
        background: '#6AC0FF'
      }
    };
    return React.createElement("div", {
      "className": "menubar"
    }, React.createElement(Tabs, {
      "style": styles.slide,
      "className": "container",
      "onChange": this.handleChangeTab,
      "value": this.state.slideIndex
    }, React.createElement(Tab, {
      "label": "用户登录",
      "value": 0.,
      "className": "menubar-tabs",
      "style": styles.slide
    }), React.createElement(Tab, {
      "label": "域名认证",
      "value": 1.,
      "className": "menubar-tabs",
      "style": styles.slide
    }), React.createElement(Tab, {
      "label": "热门活动",
      "value": 2.,
      "className": "menubar-tabs",
      "style": styles.slide
    })));
  }
});

module.exports = IntroMenu;
