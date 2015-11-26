$(document).ready(function() {
        $('#BookContainer').jtable({
                title : 'Book Inventory',
                paging: true, //Set paging enabled
                pageSize: 10, //Set page size
                sorting: true,
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
                                list : false,
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
                },
                toolbar: {
                    items: [{
                        icon: '/images/excel.png',
                        text: 'Export to Excel',
                        click: function () {
                            //perform your custom job...
                        	//alert("Excel clicked");
                        	//tableToExcel('BookContainer','Table Export');
                        }
                    },{
                        icon: '/images/pdf.png',
                        text: 'Export to Pdf',
                        click: function () {
                            //perform your custom job...
                        }
                    }]
                }
        });
        
        //$('#BookContainer').jtable('load');
        
        //Re-load records when user click 'load records' button.
        $('#LoadRecordsButton').click(function (e) {
            e.preventDefault();
            $('#BookContainer').jtable('load', {
            	title: $('#title').val(),
            	authorFName: $('#authorFName').val()
            });
        });
 
        //Load all records when page is first shown
        $('#LoadRecordsButton').click();
});