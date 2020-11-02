import React, {Component} from 'react';
import {Button, Card, Col, Form, InputGroup} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList, faPlusSquare, faSave, faUndo} from "@fortawesome/free-solid-svg-icons";
import axios from "axios";


class TestProduct extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
            categories: [],
            selectedCategory: ""
        };

        this.fetchCategories = this.fetchCategories.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.submitProduct = this.submitProduct.bind(this);
    };


    componentDidMount() {
        this.fetchCategories();
    };

    fetchCategories() {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/categories")
            .then(response => {
                this.setState({categories: response.data});
                console.log(response.data);
            });
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
            .then(response => console.log(response.data))
    };

    handleChange = event => {
        console.log(event.target.value);
        this.setState({[event.target.name]: event.target.value})
    };

    render() {

        return (
            <div>
                <Card>
                    <Card.Header><FontAwesomeIcon icon={faPlusSquare}/> Information About Your Product</Card.Header>
                    <Form id={"productFormId"} onSubmit={this.submitProduct}>
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} xs={8} controlId={"formProductName"}>
                                    <Form.Label>What are you renting ?</Form.Label>
                                    <Form.Control required
                                                  type={"name"}
                                                  value={this.state.name}
                                                  onChange={this.handleChange}
                                                  placeholder="Only a few words..."/>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formCategory"}>
                                    <Form.Label>Category</Form.Label>
                                    <Form.Control required
                                                  type={"category"}
                                                  value={this.state.selectedCategory}
                                                  onChange={(event) => {
                                                      this.setState({selectedCategory: event.target.value})
                                                  }}
                                                  as={"select"}>
                                        <option>Select...</option>
                                        {this.state.categories.map((category) =>
                                            <option key={category.id}>{category.name}</option>)
                                        }
                                    </Form.Control>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} xs={8} controlId={"formAddress"}>
                                    <Form.Label>Location</Form.Label>
                                    <Form.Control required
                                                  type={"location"}
                                                  onChange={this.handleChange}
                                                  as={"select"}>
                                        <option>Where do you want to rent it...</option>
                                        <option>Ho Chi Minh</option>
                                        <option>Ha Noi</option>
                                    </Form.Control>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formPrice"}>
                                    <Form.Label>Daily Price</Form.Label>
                                    <InputGroup className={"mb-3"}>
                                        <Form.Control required
                                                      type={"pricePerDay"}
                                                      value={this.state.pricePerDay}
                                                      onChange={this.handleChange}
                                                      placeholder="Give it a value"/>
                                        <InputGroup.Append>
                                            <InputGroup.Text>€</InputGroup.Text>
                                        </InputGroup.Append>
                                    </InputGroup>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} controlId={"formInputText"}>
                                    <Form.Label>Description</Form.Label>
                                    <Form.Control as={"textarea"}
                                                  type={"description"}
                                                  value={this.state.description}
                                                  onChange={this.handleChange}
                                                  aria-label={"Description"}/>
                                </Form.Group>
                            </Form.Row>
                            <input className="image-upload" type={"file"}/>
                        </Card.Body>
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
                    </Form>
                </Card>
            </div>
        );
    }
}

export default TestProduct;