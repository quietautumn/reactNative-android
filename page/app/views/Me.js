import React,{ Component } from 'react';
import{
    Text,
    View,
    TouchableOpacity
} from 'react-native';


export default class Home extends Component{
    constructor(props){
        super(props);
        this.state = {

        }
    }
    render(){
        return(
            <View>
                <Text>个人中心</Text>
            </View>
        )
    }
}