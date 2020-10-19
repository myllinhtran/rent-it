import React, {Component} from 'react';
import Card from "react-bootstrap/Card";


class Products extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };
    };

    render() {
        return (
            <div>
                <Card>
                    <Card.Header>

                    </Card.Header>
                </Card>
            </div>
        );
    }
}

export default Products;