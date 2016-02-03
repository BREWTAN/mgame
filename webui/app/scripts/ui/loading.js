var Loading, React, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Loading = React.createClass({
  contextTypes: {
    router: React.PropTypes.object
  },
  getInitialState: function() {},
  render: function() {
    console.log("render::login.cs");
    return React.createElement("div", null, "loading");
  }
});

module.exports = Loading;

injectTapEventPlugin();
