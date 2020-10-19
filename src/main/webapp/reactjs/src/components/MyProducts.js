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
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/rentedProducts")
            .then(response => console.log(response.data))
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