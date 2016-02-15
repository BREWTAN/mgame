React = window.React = require("react")
ReactDOM = require("react-dom")
injectTapEventPlugin = require("react-tap-event-plugin");
RaisedButton = require("material-ui/lib/raised-button");

TextField = require('material-ui/lib/text-field');


Timer = require("./ui/Timer.coffee")
Login = require("./ui/login.js")
Loading = require("./ui/loading.js")
IntroMenu = require("./ui/IntroMenu.js")
GameMenu = require("./ui/GameMenu.js")
gm_CQSSC = require("./ui/gm_CQSSC.js")

CommentBox = require("./ui/CommentBox.jsx")

ReactCSSTransitionGroup = require('react-addons-css-transition-group');


{ Router, Route, Link ,hashHistory,browserHistory} =require( 'react-router')


mountNode = document.getElementById("app")



CAPP = React.createClass(
    displayName: "CAPP"
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
                React.createElement("div",className:"appdiv container-fluid",key:@props.location.pathname,@props.children)
#                React.cloneElement(@props.children, {
#                  key: @props.location.pathname
#                })
        )
#        else
#            React.createElement "div", null, React.createElement(Login, {onLoginSuccess:@onLoginSuccess})
)

TopMenu = React.createClass(
    getInitialState: ->
        items: []
        text: ""
    render: ->
        console.log("topmenuRender:"+@props.location.pathname)
        React.createElement("div",className:"",key:@props.location.pathname,@props.children)
)

routeConfig = {
    path: '/',
    component: CAPP,
    indexRoute: { component: Login },

    childRoutes: [

        { path: 'comment', component: CommentBox },
        { path: 'login', component: Login },
        { path: 'ug/*', component: gm_CQSSC },

        { path: 'ug/cqssc', component: gm_CQSSC },
        { path: 'loading', component: Loading}
    ]
}

gmenuRouteConfig = {
    path: '/',
    component: TopMenu,
    indexRoute: { component: IntroMenu },

    childRoutes: [
        { path: 'ug/*', component: GameMenu },
    ]
}

ReactDOM.render React.createElement(Router, routes:routeConfig,history:hashHistory), mountNode
ReactDOM.render React.createElement(Router, routes:gmenuRouteConfig,history:hashHistory), document.getElementById("gamemenu")


