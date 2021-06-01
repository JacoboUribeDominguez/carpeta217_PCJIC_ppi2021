import firebase from "firebase/app"
import 'firebase/storage';

const firebaseConfig = {
    apiKey: "AIzaSyCK3a6KQO1G9nFizDyJOaacidgNLCCJlgU",
    authDomain: "saferide-94149.firebaseapp.com",
    projectId: "saferide-94149",
    storageBucket: "saferide-94149.appspot.com",
    messagingSenderId: "1043371674204",
    appId: "1:1043371674204:web:8f4e8967ef7983f0413499"
};
firebase.initializeApp(firebaseConfig);


const storage = firebase.storage();

export {
    storage
}