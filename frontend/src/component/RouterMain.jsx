// rcc
import React, { Component } from 'react'
import Footer from './Footer';
import Header from './Header';
import Main from './Main';

// i18n 
import { withTranslation } from 'react-i18next';

// CLASS COMPONENT
class RouterMain extends Component {

    // Componentteki yeni isim
   static displayName="Blog_Router"

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
            // <React.Fragment>FooRouterMainter</React.Fragment>
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

export default withTranslation()(RouterMain)