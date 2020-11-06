import React, {Component} from 'react';
import Bob from './img/Bob.png';
import {Card} from "react-bootstrap";
import axios from 'axios';


class ProductDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
            rentedProduct: []
        };

        this.findProductById = this.findProductById.bind(this);
        this.findRenterByProductId = this.findRenterByProductId.bind(this);
    };

    rentedProduct = {
        productId: '',
        category: [],
        product: [],
        rentee: [],
        renter: {
            renterId: '',
            firstName: '',
            lastName: '',
            email: '',
            mobile: ''
        },
        address: '',
        startDate: '',
        endDate: ''
    };

    componentDidMount() {
        const productId = this.props.match.params.id;
        if (productId) {
            this.findProductById(productId);
            this.findRenterByProductId(productId);
        }
        console.log(this.state.rentedProduct)
    };

    findProductById = (productId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/products/" + productId)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        id: response.data.id,
                        name: response.data.name,
                        description: response.data.description,
                        pricePerDay: response.data.pricePerDay,
                    });
                    console.log(response.data);
                }
            });
    };

    findRenterByProductId = (productId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/accounts/rented-products?productId=" + productId)
            .then(response => {
                console.log(response.data)
                this.setState({
                    rentedProduct: response.data
                })
            });
    };

    render() {

        const {id, name, description, pricePerDay} = this.state;

        return (
            <div className={"product-container"}>
                <Card className="border border-grey bg-light text-dark">
                    <Card.Header> ID: {id}</Card.Header>
                    <Card.Body>
                        <Card.Title style={{
                            margin: "0px 20px 15px 0px",
                            fontSize: "25px",
                            fontWeight: "normal"
                        }}>{name}</Card.Title>
                        <Card.Subtitle style={{fontSize: "35px"}}>{pricePerDay} €</Card.Subtitle>
                    </Card.Body>
                    <Card.Img src={Bob} alt={"Bob"} className={"img-product"}/>
                    <Card.Text style={{margin: "20px"}}>{description}</Card.Text>
                </Card>
            </div>
        );
    }
}

export default ProductDetail;