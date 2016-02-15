React = require("react")
injectTapEventPlugin = require("react-tap-event-plugin");

Tabs  = require("material-ui/lib/tabs/tabs");
Tab  = require("material-ui/lib/tabs/tab");
# From https://github.com/oliviertassinari/react-swipeable-views



IntroMenu = React.createClass(

    getInitialState:() ->
        slideIndex: 0

    handleChangeTab:(vv) ->
        console.log("changetab:"+vv)
        @setState
            slideIndex: vv

    render:() ->
        styles = {
          slide: {
            fontSize: "18px",
          },
          slide1: {
            background: '#FEA900',
          },
          slide2: {
            background: '#B3DC4A',
          },
          slide3: {
            background: '#6AC0FF',
          },
        };
        return (

         <div className ="menubar">
               <Tabs
                 style={styles.slide}
                 className="container"
                 onChange={@handleChangeTab}
                 value={@state.slideIndex}
               >
                 <Tab label="用户登录" value={0} className = "menubar-tabs" style={styles.slide}>

                 </Tab>
                 <Tab label="域名认证" value={1} className = "menubar-tabs" style={styles.slide}/>
                 <Tab label="热门活动" value={2} className = "menubar-tabs" style={styles.slide}/>
               </Tabs>


         </div>
        );
)

module.exports = IntroMenu

