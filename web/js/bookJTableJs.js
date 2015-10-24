$(document).ready(function() {
        $('#BookContainer').jtable({
                title : 'Book Inventory',
               // paging: true, //Set paging enabled
               // pageSize: 3, //Set page size
                actions : {
                        listAction :   'Controller?action=list',
                        createAction : 'Controller?action=create',
                        updateAction : 'Controller?action=update',
                        deleteAction : 'Controller?action=delete'
                },
                fields : {
                		bookId : {
                                title : 'Book Id',
                                width : '5%',
                                key : true,
                                list : true,
                                edit : false,
                                create : true
                        },
                        title : {
                                title : 'Title',
                                width : '20%',
                                edit : true
                        },
                        authorFName : {
                                title : 'Author FirstName',
                                width : '10%',
                                edit : true
                        },
                        authorLName : {
                                title : 'Author LastName',
                                width : '10%',
                                edit : true
                        },
                        category : {
                            title : 'Category',
                            width : '10%',
                            edit : true
                        },
                        description : {
                            title : 'Description',
                            width : '30%',
                            edit : true
                        },
                        publisher : {
                            title : 'Publisher',
                            width : '10%',
                            edit : true
                        },
                        price : {
                            title : 'Price',
                            width : '5%',
                            edit : true
                        }
                }
        });
        $('#BookContainer').jtable('load');
});