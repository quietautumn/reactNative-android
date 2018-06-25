import { StackNavigator,TabNavigator } from 'react-navigation';
import Login from './views/Login';
import Home from './views/Home';
import Me from './views/Me';


const TabScreen = TabNavigator({
    Home: { screen: Home },
    Me: { screen: Me },
    },
    tabStyle = {
        tabBarPosition: 'bottom',
})


const Root = StackNavigator({
    Login: { 
        screen: Login,
        navigationOptions: {
            header: null,
        }
    },
    Home: { 
        screen: TabScreen ,
        navigationOptions: {
            header: null,
        }
    },
})

export default Root