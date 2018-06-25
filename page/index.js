import { AppRegistry } from 'react-native';
import Root from './app/Root';
import MyReactActivity from './MyReactActivity';

AppRegistry.registerComponent('page', () => Root);
AppRegistry.registerComponent('hello', () => MyReactActivity);  
