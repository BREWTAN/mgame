React = window.React = require("react")
ReactDOM = require("react-dom")
injectTapEventPlugin = require("react-tap-event-plugin");
RaisedButton = require("material-ui/lib/raised-button");

TextField = require('material-ui/lib/text-field');


Timer = require("./ui/Timer.coffee")
Login = require("./ui/login.js")
Loading = require("./ui/loading.js")

CommentBox = require("./ui/CommentBox.jsx")

ReactCSSTransitionGroup = require('react-addons-css-transition-group');


{ Router, Route, Link ,hashHistory,browserHistory} =require( 'react-router')


mountNode = document.getElementById("app")



WAPP = React.createClass(
    displayName: "WAPP"
    getInitialState: ->
        items: []
        text: ""
        logined: false

    doLogin: ->
        console.log("logininin")

    onChange: (e) ->
        @setState text: e.target.value
        return

    onLoginSuccess:(userinfo) ->
        @setState logined: true
        console.log("loginOKOK")
        return

    handleSubmit: (e) ->
        e.preventDefault()
        nextItems = @state.items.concat([@state.text])
        nextText = ""
        @setState
            items: nextItems
            text: nextText

        return

    render: ->
#        console.log("render app");
#        if @state.logined
#            React.createElement "div", null, React.createElement(TodoList,
#                items: @state.items
#            ), React.createElement("form",
#                onSubmit: @handleSubmit
#            , React.createElement(TextField,
#                    onChange: @onChange
#                    value: @state.text
#                ), React.createElement(RaisedButton,
#                    onClick: @handleSubmit, "Add #" + (@state.items.length + 1))), React.createElement(Timer, null)
#            , React.createElement(CommentBox, null)
        console.log("render app:"+@props.location.pathname)
        React.createElement(ReactCSSTransitionGroup,
                transitionName:"fade",
                transitionEnterTimeout:500,
#                transitionAppear:true,
#                transitionAppearTimeout:2000,
                transitionLeaveTimeout:500,
                React.createElement("div",className:"appdiv container",key:@props.location.pathname,@props.children)
#                React.cloneElement(@props.children, {
#                  key: @props.location.pathname
#                })
        )
#        else
#            React.createElement "div", null, React.createElement(Login, {onLoginSuccess:@onLoginSuccess})
)


routeConfig = {
    path: '/',
    component: WAPP,
    indexRoute: { component: Login },

    childRoutes: [
        { path: 'comment', component: CommentBox },
        { path: 'login', component: Login },
        { path: 'loading', component: Loading}
    ]
}

ReactDOM.render React.createElement(Router, routes:routeConfig,history:hashHistory), mountNode


