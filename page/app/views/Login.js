import React,{ Component } from 'react';
import{
    Text,
    View,
    TouchableOpacity,
    NativeModules,
} from 'react-native';
import { StackActions,NavigationActions } from 'react-navigation'


export default class Login extends Component{
    constructor(props){
        super(props);
    }
    componentDidMount() { //这是React的生命周期函数，会在界面加载完成后执行一次 
         NativeModules.MyNativeModule.getDataFromIntent(
            (successMsg) => {
                alert(successMsg)
            },
            (errorMsg) => {
                alert(errorMsg)
            }
        );
    }
    getHome(){
        const resetAction = StackActions.reset({
            index: 0,
            actions: [NavigationActions.navigate({ routeName: 'Home' })],
        });
        this.props.navigation.dispatch(resetAction);
    }  
    getLogin(){
        NativeModules.MyNativeModule.startActivityByString("com.mht.app.DetailsActivity", "标题")
    }
    render(){
        return(
            <View style={{flex:1,justifyContent:'center',alignItems:'center'}}>
                <TouchableOpacity onPress={ this.getLogin.bind(this) }>
                    <Text>跳转到安卓页面</Text>
                </TouchableOpacity>
            </View>
        )
    }
}