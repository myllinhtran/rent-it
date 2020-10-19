import React, {Component} from 'react';
import axios from 'axios';

class MyProducts extends Component {

    constructor(props) {
        super(props);
        this.state = {
            myProducts: []
        };
    }

    componentDidMount() {
        axios.get("")
    };

    render() {

        return (
            <div>
                Return rendered content of My Products.
            </div>
        )
    }
}

export default MyProducts;