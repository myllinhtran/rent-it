import React, {Component} from 'react';
import axios from 'axios';
import {Card, Form, Col, Button, InputGroup} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList, faPlusSquare, faSave, faUndo} from "@fortawesome/free-solid-svg-icons";


class Product extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
            categories: []
        };

        this.submitProduct = this.submitProduct.bind(this);
        this.productChange = this.productChange.bind(this);
        this.categoryList = this.categoryList.bind(this);
    };

    componentDidMount() {
        this.categoryList();
    };

    submitProduct = event => {
        event.preventDefault();
        const product = {
            categoryId: this.state.categoryId,
            productName: this.state.name,
            pricePerDay: this.state.pricePerDay,
            description: this.state.description
        };

        axios.post("https://safe-sierra-04090.herokuapp.com/api/v1/products", product)
            .then(response => {
                if (response.data != null) {
                    this.setState({"show": true});
                    setTimeout(() => this.setState({"show": false}), 3000);
                } else {
                    this.setState({"show": false});
                }
            });
    };

    productChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    categoryList() {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/categories")
            .then(response => {
                const categories = response.data;
                this.setState({categories});
            });
    };

    findCategoryId = (category) => {

    };

    render() {
        return (
            <div>
                <Card>
                    <Card.Header><FontAwesomeIcon icon={faPlusSquare}/> Information About Your Product</Card.Header>
                    <Form onSubmit={this.submitProduct} id={"productFormId"}>
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} xs={8} controlId={"formProductName"}>
                                    <Form.Label>What are you renting ?</Form.Label>
                                    <Form.Control required placeholder="Only a few words..."/>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formPrice"}>
                                    <Form.Label>Daily Price</Form.Label>
                                    <InputGroup className={"mb-3"}>
                                        <Form.Control required placeholder="Give it a value"/>
                                        <InputGroup.Append>
                                            <InputGroup.Text>€</InputGroup.Text>
                                        </InputGroup.Append>
                                    </InputGroup>
                                </Form.Group>
                            </Form.Row>

                            <Form.Row>
                                <Form.Group as={Col} xs={8} controlId={"formAddress"}>
                                    <Form.Label>Location</Form.Label>
                                    <Form.Control as={"select"}>
                                        <option>Where do you want to rent it...</option>
                                        <option>Ho Chi Minh</option>
                                        <option>Ha Noi</option>
                                    </Form.Control>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formCategory"}>
                                    <Form.Label>Category</Form.Label>
                                    <Form.Control as={"select"}>
                                        <option>Select...</option>
                                        {this.state.categories.map((category) =>
                                            <option key={category.id}>{category.name}</option>
                                        )}
                                    </Form.Control>
                                </Form.Group>
                            </Form.Row>

                            <Form.Row>
                                <Form.Group as={Col} controlId={"formInputText"}>
                                    <Form.Label>Description</Form.Label>
                                    <Form.Control as={"textarea"} aria-label={"Description"}/>
                                </Form.Group>
                            </Form.Row>

                            <input className="image-upload" type={"file"}/>

                        </Card.Body>
                    </Form>
                    <Card.Footer style={{"textAlign": "right"}}>
                        <Button variant={"success"} type={"submit"}>
                            <FontAwesomeIcon icon={faSave}/> Upload
                        </Button>{' '}
                        <Button variant={"info"} type={"reset"}>
                            <FontAwesomeIcon icon={faUndo}/> Clear
                        </Button>{' '}
                        <Button variant={"info"} type={"button"}>
                            <FontAwesomeIcon icon={faList}/> My Products
                        </Button>{' '}
                    </Card.Footer>
                </Card>
            </div>
        );
    }
}

export default Product;