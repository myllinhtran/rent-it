import React, {Component} from 'react';
import Account from "./Account";
import axios from "axios";
import {Tabs, TabPane, Card, Table} from "react-bootstrap";
import {faList} from "@fortawesome/free-solid-svg-icons";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";


class Profile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            activeTab: props.activeTab || 1,
            rentedProducts: [],
            rentingProducts: []
        };

        this.handleSelect = this.handleSelect.bind(this);
        this.getRentedProducts = this.getRentedProducts.bind(this);
        this.findAccountById = this.findAccountById.bind(this);
    };


    componentDidMount() {
        const accountId = this.props.match.params.id;
        if (accountId) {
            this.findAccountById(accountId);
            this.getRentedProducts(accountId);
        }
    };

    getRentedProducts = (accountId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/accounts/" + accountId + "/rented-products")
            .then(response => response.data)
            .then((data) => {
                this.setState({rentedProducts: data});
                console.log(data);
            })
    };

    findAccountById = (accountId) => {
        axios.get("https://safe-sierra-04090.herokuapp.com/api/v1/accounts/" + accountId)
            .then(response => {
                if (response.data != null) {
                    this.setState({
                        id: response.data.id,
                        firstName: response.data.firstName,
                        lastName: response.data.lastName,
                        mobile: response.data.mobile,
                        email: response.data.email
                    })
                }
                console.log(response.data);
            })
    };

    productId; // ???


    handleSelect(selectedTab) {
        this.setState({
            activeTab: selectedTab,
        });
    };

    render() {

        const {id, firstName, lastName, mobile, email} = this.state;

        return (
            <div className={"card-body"}>
                <Tabs defaultActiveKey={"account"} onSelect={this.handleSelect} transition={false}>
                    <TabPane eventKey={"account"} title={"Account"}>
                        <Account
                            id={id}
                            firstName={firstName}
                            lastName={lastName}
                            mobile={mobile}
                            email={email}
                        />
                    </TabPane>
                    <TabPane eventKey={"rentedProduct"} title={"Rented Products"}>
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
                                    {this.state.rentedProducts.map((rentedProduct) => {
                                        return (
                                            <tr key={rentedProduct.id}>
                                                <td align={"center"}>{rentedProduct.id}</td>
                                                <td>{rentedProduct.categoryId.name}</td>
                                                <td>{rentedProduct.productId.name}</td>
                                                <td align={"center"}>{rentedProduct.productId.pricePerDay}</td>
                                                <td>{rentedProduct.productId.description}</td>
                                            </tr>
                                        )
                                    })}
                                    </tbody>
                                </Table>
                            </Card.Body>
                        </Card>
                    </TabPane>
                    <TabPane eventKey={"rentingProduct"} title={"Renting Products"}>
                        <br/>
                        <Card className={"border border-grey bg-light text-dark"}>
                            <Card.Header>
                                <FontAwesomeIcon icon={faList}/> My Products For Rent
                            </Card.Header>
                            <Card.Body>
                                <Table bordered hover striped>
                                    <thead>
                                    <tr align={"center"}>
                                        <th>ID</th>
                                        <th>Category</th>
                                        <th>Product Name</th>
                                        <th>Daily Pricing</th>
                                        <th>Action</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    </tbody>
                                </Table>
                            </Card.Body>
                        </Card>
                    </TabPane>
                </Tabs>
            </div>
        );
    }
}

export default Profile;