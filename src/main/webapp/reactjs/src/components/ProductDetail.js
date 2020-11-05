import React, {Component} from 'react';
import Bob from './img/Bob.png';
import home_img from './img/home_img.png';
import {Card, Row, Col} from "react-bootstrap";
import axios from 'axios';
import Carousel from "react-bootstrap/Carousel";

class ProductDetail extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: [],
            selectedIndex: '',
            date: ''
        }
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
                        name: response.data.name,
                        description: response.data.description,
                        pricePerDay: response.data.pricePerDay,
                    })
                }
            });
    };


    render() {

        const {id, name, description, pricePerDay} = this.state;

        return (
            <div style={{margin: "20px 60px 80px 60px"}}>
                <Card className="border border-grey bg-light text-dark">
                    <Card.Header>ID: {id}</Card.Header>
                    <Card.Body>
                        <Row>
                            <Col>
                                <Carousel align={"center"}>
                                    <Carousel.Item>
                                        <img src={Bob} alt={"Bob"} className={"carousel-img"}/>
                                    </Carousel.Item>
                                    <Carousel.Item>
                                        <img src={home_img} alt={"home_img"} className={"carousel-img"}/>
                                    </Carousel.Item>
                                </Carousel>
                            </Col>
                            <Col>
                                <Card>
                                    <Card.Header style={{fontSize: "20px"}}>{name}</Card.Header>
                                    <Card.Body>
                                        <Card.Title style={{fontSize: "35px"}}>{pricePerDay} €</Card.Title>
                                        <Card.Text>
                                            <p>{description}</p>
                                        </Card.Text>
                                    </Card.Body>
                                </Card>
                            </Col>
                        </Row>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

export default ProductDetail;