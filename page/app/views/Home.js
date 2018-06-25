import React,{ Component } from 'react';
import{
    Text,
    View,
    TouchableOpacity,
    BackAndroid,
    Modal,
    Button,
    StyleSheet,
    NativeModules
} from 'react-native';
import { StackActions,NavigationActions } from 'react-navigation'


export default class Home extends Component{
    constructor(props){
        super(props);
        this.state = {
            isLogin: false,
            transparent: true,
        }
    }
    componentDidMount(){
        
    }
    render(){
        return(
            <View>
                <Text>首页</Text>
            </View>
        )
    }
}
