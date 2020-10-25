import React, {Component} from 'react';
import {Card, Table} from 'react-bootstrap';
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import {faList} from "@fortawesome/free-solid-svg-icons";
import axios from 'axios';

class RentedProducts extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };
    }

    componentDidMount() {

    };


    render() {

        return (
            <div>
                <br/>
                <Card className={"border border-grey bg-light text-dark"}>
                    <Card.Header>
                        <FontAwesomeIcon icon={faList}/> My Rented Products
                    </Card.Header>
                    <Card.Body>
                        <Table bordered hover striped>
                            <thead>
                            <tr align={"center"}>
                                <th>ID</th>
                                <th>Category</th>
                                <th>Product Name</th>
                                <th>Daily Pricing</th>
                                <th>Description</th>
                            </tr>
                            </thead>
                            <tbody>

                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </div>
        )
    }
}

export default RentedProducts;