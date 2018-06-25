import React, {Component} from 'react';  
import {  
    StyleSheet,
    NativeModules,
    TextInput,
    View,
} from 'react-native';

export default class MyReactActivity extends React.Component {  
    constructor(props) {
        super(props);
        this.state = {
            TEXT: 'Input Text',
        };
    }

    render() {
        return (
            <View style={styles.container}>
                <TextInput
                    style={styles.welcome}
                    onChangeText={(text) => this.setState({text})}
                    value={this.state.TEXT}/>
            </View>
        )
    }

    componentDidMount() {
        NativeModules.MyNativeModule.getDataFromIntent(
            (successMsg) => {
                this.setState({TEXT: successMsg,});
            },
            (errorMsg) => {
                alert(errorMsg)
            }
        );
    }
}

const styles = StyleSheet.create({  
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: '#F5FCFF',
    },
    welcome: {
        fontSize: 20,
        textAlign: 'center',
        margin: 10,
    },
});