import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";

import { Fab } from "@material-ui/core";
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import ViewStreamIcon from '@mui/icons-material/ViewStream';

class Cart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cartItems: [],
            isCheckout: false,
            cartHidden: false,
        }
        this.handleCheckout = this.handleCheckout.bind(this);
    }

    async handleCheckout() {
        try{
            const {data} = await APIConfig.get(`/cart/checkout`);
            // console.log(data);
            this.loadCart();
            alert(data);
        } catch(error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadCart() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ 
                cartItems : data.result,

            });
            
            // console.log(this.state.cartItems)
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }   

    componentDidMount() {
        this.loadCart();
    }

    render() {
        return (
            <div className={classes.itemList}>
                
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <a href="/itemlist">
                        <Fab variant="extended" onClick={this.handleToggle} >
                            {this.state.cartHidden ? (
                                <Badge
                                    color="secondary"
                                    badgeContent={this.state.cartItems.length}
                                >
                                    <ShoppingCartIcon />
                                </Badge>
                            ) : (
                                <ViewStreamIcon />
                            )}
                        </Fab>
                    </a>
                </div>

                <h1 className={classes.title}>
                    Keranjang
                </h1>
                <Button action={this.handleCheckout}>
                    Checkout
                </Button>
                <div>
                    {this.state.cartItems.map((item) => (
                        <Item
                            key={item.item.id}
                            id={item.item.id}
                            title={item.item.title}
                            price={item.item.price}
                            description={item.item.description}
                            category={item.item.category}
                            quantity={item.quantity}
                            isCart={true}
                        />
                    ))}
                </div>
            </div>
        );
    }
}

export default Cart;