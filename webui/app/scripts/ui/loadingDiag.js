var Dialog, FlatButton, Loader, LoadingDiag, RaisedButton, React, injectTapEventPlugin;

React = require("react");

injectTapEventPlugin = require("react-tap-event-plugin");

Loader = require('halogen/RingLoader');

Dialog = require('material-ui/lib/dialog');

FlatButton = require('material-ui/lib/flat-button');

RaisedButton = require('material-ui/lib/raised-button');

LoadingDiag = React.createClass({
  contextTypes: {
    router: React.PropTypes.object
  },
  getInitialState: function() {
    return {
      open: false
    };
  },
  handleOpen: function() {
    return this.props.open = true;
  },
  handleClose: function() {
    console.log("close:");
    return this.props.handleDiagClose();
  },
  render: function() {
    var actions, child, pstyle, style;
    console.log("render::loading:open=" + this.state.open + ",props=" + this.props.open);
    style = {
      display: '-webkit-flex',
      display: 'flex',
      webkitFlex: '0 1 auto',
      flex: '0 1 auto',
      webkitFlexDirection: 'column',
      flexDirection: 'column',
      webkitFlexGrow: 1,
      flexGrow: 1,
      webkitFlexShrink: 0,
      flexShrink: 0,
      webkitFlexBasis: '25%',
      flexBasis: '25%',
      maxWidth: '25%',
      webkitAlignItems: 'center',
      alignItems: 'center',
      webkitJustifyContent: 'center',
      justifyContent: 'center'
    };
    pstyle = {
      height: '100%',
      width: '100%',
      margin: 0,
      justifyContent: 'center',
      boxSizing: 'border-box',
      display: '-webkit-flex',
      display: 'flex',
      webkitFlex: '0 1 auto',
      flex: '0 1 auto',
      webkitFlexDirection: 'row',
      flexDirection: 'row',
      webkitFlexWrap: 'wrap',
      flexWrap: 'wrap'
    };
    if (this.props.message === '') {
      child = React.createElement("div", {
        "style": pstyle
      }, React.createElement("div", {
        "style": style,
        "zDepth": 1.
      }, React.createElement(Loader, {
        "color": "#26A65B",
        "margin": "20px"
      })));
      actions = [];
    } else {
      child = '';
      actions = [
        React.createElement(FlatButton, {
          "label": "确定",
          "primary": true,
          "onTouchTap": this.handleClose
        })
      ];
    }
    console.log("message=" + this.props.message + ",child=" + child);
    return React.createElement("div", {
      "className": "container-fluid"
    }, React.createElement(Dialog, {
      "modal": true,
      "actions": actions,
      "open": this.props.open,
      "title": this.props.message
    }, child));
  }
});

module.exports = LoadingDiag;
