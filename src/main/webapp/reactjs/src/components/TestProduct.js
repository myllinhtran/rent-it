import React, {Component} from 'react';
import {Card, Form, Col, Button} from 'react-bootstrap';
import axios from 'axios';

class TestProduct extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };

        this.submitProduct = this.submitProduct.bind(this);
    }

    submitProduct = event => {
        event.preventDefault();
        const product = {
            id: "",
            categoryId: 2,
            name: "Honda Vision 2017",
            pricePerDay: 60,
            description: "Detail information of Honda Vision 2017"
        };

        axios.post("https://safe-sierra-04090.herokuapp.com/api/v1/products", product)
            .then(response => console.log(response.data));
    };

    render() {
        return (
            <div>
                <Card>
                    <Card.Header>Information About Your Product</Card.Header>
                    <Form id={"productFormId"} onSubmit={this.submitProduct}>
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} controlId={"formCategoryId"}>
                                    <Form.Label>Category ID</Form.Label>
                                    <Form.Control/>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formProductName"}>
                                    <Form.Label>Product Name</Form.Label>
                                    <Form.Control/>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} controlId={"formPrice"}>
                                    <Form.Label>Price Per Day</Form.Label>
                                    <Form.Control/>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formInputText"}>
                                    <Form.Label>Description</Form.Label>
                                    <Form.Control/>
                                </Form.Group>
                            </Form.Row>
                        </Card.Body>
                        <Card.Footer>
                            <Button type={"submit"} variant={"success"}>Upload</Button>
                        </Card.Footer>
                    </Form>
                </Card>
            </div>
        );
    }
}

export default TestProduct;