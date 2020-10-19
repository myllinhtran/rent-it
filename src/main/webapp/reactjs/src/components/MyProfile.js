import React, {Component} from 'react';
import {Tabs, Tab} from 'react-bootstrap';
import Account from "./Account";
import MyProducts from "./MyProducts";

class MyProfile extends Component {

    constructor(props) {
        super(props);
        this.state = {
            activeTab: props.activeTab || 1
        };

        this.handleSelect = this.handleSelect.bind(this);
    }

    handleSelect(selectedTab) {
        this.setState({
            activeTab: selectedTab
        });
    }

    render() {
        return (
            <div className={"card-body"}>
                <Tabs defaultActiveKey={"account"} onSelect={this.handleSelect}>
                    <Tab eventKey={"account"} title={"Account"}>
                        <div>
                            <p><Account/></p>
                        </div>
                    </Tab>
                    <Tab eventKey={"products"} title={"My Products"}>
                        <div>
                            <p><MyProducts/></p>
                        </div>
                    </Tab>
                </Tabs>
            </div>
        );
    }
}

export default MyProfile;