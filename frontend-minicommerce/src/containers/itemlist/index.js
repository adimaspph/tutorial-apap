import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
        }

        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearch = this.handleSearch.bind(this);
        this.handleDelete = this.handleDelete.bind(this);

    }

    handleAddItem() {
        this.setState({ isCreate:true });
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate:false, isEdit: false });
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    handleEditItem(item) {
        this.setState({
            isEdit: true,
            id: item.id,
            title: item.title,
            price: item.price,
            description: item.description,
            category: item.category,
            quantity: item.quantity
        })
    }
        
    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSearch(event) {
        event.preventDefault();
        try {
            const { data } = await APIConfig.get("/item", {params: {title: event.target.value}});
            
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleDelete(item) {
        // item.preventDefault();
        console.log(item.id);
        try {
            await APIConfig.delete(`/item/${item.id}`);
            // this.setState({
            //     id: "",
            //     title: "",
            //     price: 0,
            //     description: "",
            //     category: "",
            //     quantity: 0
            // })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }
    
    componentDidMount() {
        this.loadData();
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }        

    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }
        
    render() {
        return (
            <div className={classes.itemList}>

                <h1 className={classes.title}>
                    All Items
                </h1>

                <input  
                    className={classes.textField}
                    type="text"
                    placeholder="Search"
                    name="search"
                    // value={this.state.search}
                    onChange={this.handleSearch}
                />

                <Button action={this.handleAddItem}>
                    Add Item
                </Button>

                <div>
                    {this.state.items.map((item) => (
                        <Item
                            key={item.id}
                            id={item.id}
                            title={item.title}
                            price={item.price}
                            description={item.description}
                            category={item.category}
                            quantity={item.quantity}
                            handleEdit={() => (this.handleEditItem(item))}
                            handleDelete={() => (this.handleDelete(item))}
                        />
                    ))}
                </div>
                <Modal
                    show={this.state.isCreate || this.state.isEdit}
                    handleCloseModal={this.handleCancel}
                    modalTitle={this.state.isCreate ? "Add Item" : `Edit Item ID ${this.state.id}`}>
                    <form>
                    <input
                        className={classes.textField}
                        type="text"
                        placeholder="Nama Item"
                        name="title"
                        value={this.state.title}
                        onChange={this.handleChangeField}
                    />
                    <input
                        className={classes.textField}
                        type="number"
                        placeholder="Harga"
                        name="price"
                        value={this.state.price}
                        onChange={this.handleChangeField}
                    />
                    <textarea
                        className={classes.textField}
                        placeholder="Deskripsi"
                        name="description"
                        rows="4"
                        value={this.state.description}
                        onChange={this.handleChangeField}
                    />
                    <input
                        className={classes.textField}
                        type="text"
                        placeholder="Kategori"
                        name="category"
                        value={this.state.category}
                        onChange={this.handleChangeField}
                    />
                    <input
                        className={classes.textField}
                        type="number"
                        placeholder="qty"
                        name="quantity"
                        value={this.state.quantity}
                        onChange={this.handleChangeField}
                    />
                    <Button action={this.state.isCreate ? this.handleSubmitItem : this.handleSubmitEditItem}>
                        Create
                    </Button>
                    <Button action={this.handleCancel}>
                        Cancel
                    </Button>
                    </form>
                </Modal>
            </div>
        );
    }
}

export default ItemList;