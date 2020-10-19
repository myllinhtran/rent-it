import React, {Component} from 'react';
import {Card, Col, Row} from "react-bootstrap";
import axios from 'axios';

class ProductDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };
    };

    componentDidMount() {
        const productId = this.props.match.params.id;
        if (productId) {
            this.findProductById(productId);
        }
    };

    findProductById = (productId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/products/" + productId)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        id: response.data.id,
                        category: response.data.categoryId.name,
                        name: response.data.name,
                        pricePerDay: response.data.pricePerDay,
                        description: response.data.description
                    })
                }
            });
    }

    render() {

        const {category, name, description, pricePerDay} = this.state;

        return (
            <div>
                <Card className="border border-dark bg-dark text-white">
                    <Card.Header>{category}</Card.Header>
                    <Card.Body>
                        <Card.Title>{name}</Card.Title>
                        <Row>
                            <Col xs={12}>{description}</Col>
                            <Col>Daily Pricing: {pricePerDay} euros</Col>
                        </Row>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

export default ProductDetail;