React = window.React = require("react")
ReactDOM = require("react-dom")
injectTapEventPlugin = require("react-tap-event-plugin");
RaisedButton = require("material-ui/lib/raised-button");

TextField = require('material-ui/lib/text-field');

Timer = require("./ui/Timer.coffee")
Login = require("./ui/login.js")

CommentBox = require("./ui/CommentBox.jsx")

{ Router, Route, Link ,hashHistory,browserHistory} =require( 'react-router')


mountNode = document.getElementById("app")



TodoList = React.createClass(
    displayName: "TodoList"
    render: ->
        createItem = (itemText) ->
            React.createElement "li", null, itemText

        React.createElement "ul", null, @props.items.map(createItem)
)

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
            @props.children
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
    ]
}

ReactDOM.render React.createElement(Router, routes:routeConfig,history:hashHistory), mountNode


