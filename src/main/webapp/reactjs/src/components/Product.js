import React, {Component} from 'react';
import {Button, Card, Col, Form, InputGroup} from "react-bootstrap";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList, faPlusSquare, faSave, faUndo} from "@fortawesome/free-solid-svg-icons";
import axios from 'axios';
import './css/Product.css';

class Product extends Component {

    constructor(props) {
        super(props);
        this.state = {
            product: [],
            categories: [],
            selectedCategory: '',
            selectedCategoryId: '',
        };

        this.fetchCategories = this.fetchCategories.bind(this);
        this.handleChange = this.handleChange.bind(this);
        this.handleCategoryChange = this.handleCategoryChange.bind(this);
        this.submitProduct = this.submitProduct.bind(this);
        this.resetProduct = this.resetProduct.bind(this);
    };

    initialState = {
        id: '',
        productName: '',
        price: '',
        description: '',
        category: {id: ''}
    };


    componentDidMount() {
        this.fetchCategories();
    };

    fetchCategories() {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/categories")
            .then(response => {
                this.setState({categories: response.data});
            });
    };

    handleChange = event => {
        this.setState({
            [event.target.name]: event.target.value
        });
    };

    handleCategoryChange = event => {
        const selectedIndex = event.target.options.selectedIndex;
        const categoryId = event.target.options[selectedIndex].getAttribute("cate-id");
        this.setState({
            selectedCategoryId: categoryId,
            selectedCategory: event.target.value
        })
    };

    submitProduct = event => {

        event.preventDefault();

        const product = {
            id: '',
            name: this.state.productName,
            pricePerDay: this.state.price,
            description: this.state.description,
            category: {id: this.state.selectedCategoryId}
        };

        axios.post("https://safe-sierra-04090.herokuapp.com/api/v1/products", product)
            .then(response => console.log(response.data));

        this.setState(() => this.initialState);
    };

    resetProduct = () => {
        this.setState(() => this.initialState);
    };

    render() {

        const {name, pricePerDay, description, selectedCategory} = this.state;

        return (
            <div className={"product-form"}>
                <Card>
                    <Card.Header><FontAwesomeIcon icon={faPlusSquare}/> Information About Your Product</Card.Header>
                    <Form id={"productFormId"} onSubmit={this.submitProduct} onReset={this.resetProduct}>
                        <Card.Body>
                            <Form.Row>
                                <Form.Group as={Col} xs={8} controlId={"formProductName"}>
                                    <Form.Label>What are you renting ?</Form.Label>
                                    <Form.Control required
                                                  name={"productName"}
                                                  onChange={this.handleChange}
                                                  value={name}
                                                  placeholder="Only a few words..."/>
                                </Form.Group>
                                <Form.Group as={Col} controlId={"formCategory"}>
                                    <Form.Label>Category</Form.Label>
                                    <Form.Control required
                                                  name={"selectedCategoryId"}
                                                  value={selectedCategory}
                                                  onChange={this.handleCategoryChange}
                                                  as={"select"}>
                                        <option>Select...</option>
                                        {
                                            this.state.categories.map((category) =>
                                                <option key={category.id} cate-id={category.id}>{category.name}</option>
                                            )}
                                    </Form.Control>
                                </Form.Group>
                            </Form.Row>
                            <Form.Row>
                                <Form.Group as={Col} xs={8} controlId={"formAddress"}>
                                    <Form.Label>Location</Form.Label>
                                    <Form.Control required
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
                                                      name={"price"}
                                                      onChange={this.handleChange}
                                                      value={pricePerDay}
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
                                    <Form.Control required
                                                  as={"textarea"}
                                                  name={"description"}
                                                  onChange={this.handleChange}
                                                  value={description}
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

export default Product;