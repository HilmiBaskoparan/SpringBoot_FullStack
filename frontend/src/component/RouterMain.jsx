// rcc
import React, { Component } from 'react'
import Footer from './Footer';
import Header from './Header';
import Main from './Main';

// CLASS COMPONENT
export default class RouterMain extends Component {
    constructor(props){
        super(props);

        // bind

        //state
        this.state = {}

        //bind
    }

    // CDM
    componentDidMount() {  }

    // FUNCTION

    // RENDER
    render() {

        // RETURN
        return (
            // <div>RouterMain</div>
            // <React.RouterMain>FooRouterMainter</React.RouterMain>
            <>
                <Header/>
                <br />
                <Main/>
                <br />
                <Footer/>
            </>
        )
    } // end render
} // end class
