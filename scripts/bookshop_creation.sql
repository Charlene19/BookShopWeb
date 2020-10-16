/*==============================================================*/
/* Nom de SGBD :  Microsoft SQL Server 2008                     */
/* Date de création :  01/09/2020 17:31:25                      */
/*==============================================================*/


if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_ADDRESS_PUBLISHER') and o.name = 'FK_ASSOC_ADDRESS_PUBLISHER_ASSOC_ADDRESS_PUBLISHER_PUBLISHER')
alter table ASSOC_ADDRESS_PUBLISHER
   drop constraint FK_ASSOC_ADDRESS_PUBLISHER_ASSOC_ADDRESS_PUBLISHER_PUBLISHER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_ADDRESS_PUBLISHER') and o.name = 'FK_ASSOC_ADDRESS_PUBLISHER_ASSOC_ADDRESS_PUBLISHER2_ADDRESS')
alter table ASSOC_ADDRESS_PUBLISHER
   drop constraint FK_ASSOC_ADDRESS_PUBLISHER_ASSOC_ADDRESS_PUBLISHER2_ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_AUTHOR') and o.name = 'FK_ASSOC_BOOK_AUTHOR_ASSOC_BOOK_AUTHOR_AUTHOR')
alter table ASSOC_BOOK_AUTHOR
   drop constraint FK_ASSOC_BOOK_AUTHOR_ASSOC_BOOK_AUTHOR_AUTHOR
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_AUTHOR') and o.name = 'FK_ASSOC_BOOK_AUTHOR_ASSOC_BOOK_AUTHOR2_BOOK')
alter table ASSOC_BOOK_AUTHOR
   drop constraint FK_ASSOC_BOOK_AUTHOR_ASSOC_BOOK_AUTHOR2_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_CATEGORY') and o.name = 'FK_ASSOC_BOOK_CATEGORY_ASSOC_BOOK_CATEGORY_BOOK')
alter table ASSOC_BOOK_CATEGORY
   drop constraint FK_ASSOC_BOOK_CATEGORY_ASSOC_BOOK_CATEGORY_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_CATEGORY') and o.name = 'FK_ASSOC_BOOK_CATEGORY_ASSOC_BOOK_CATEGORY2_CATEGORY')
alter table ASSOC_BOOK_CATEGORY
   drop constraint FK_ASSOC_BOOK_CATEGORY_ASSOC_BOOK_CATEGORY2_CATEGORY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_EVENT') and o.name = 'FK_ASSOC_BOOK_EVENT_ASSOC_BOOK_EVENT_EVENT')
alter table ASSOC_BOOK_EVENT
   drop constraint FK_ASSOC_BOOK_EVENT_ASSOC_BOOK_EVENT_EVENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_EVENT') and o.name = 'FK_ASSOC_BOOK_EVENT_ASSOC_BOOK_EVENT2_BOOK')
alter table ASSOC_BOOK_EVENT
   drop constraint FK_ASSOC_BOOK_EVENT_ASSOC_BOOK_EVENT2_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_KEYWORD') and o.name = 'FK_ASSOC_BOOK_KEYWORD_ASSOC_BOOK_KEYWORD_KEYWORD')
alter table ASSOC_BOOK_KEYWORD
   drop constraint FK_ASSOC_BOOK_KEYWORD_ASSOC_BOOK_KEYWORD_KEYWORD
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_BOOK_KEYWORD') and o.name = 'FK_ASSOC_BOOK_KEYWORD_ASSOC_BOOK_KEYWORD2_BOOK')
alter table ASSOC_BOOK_KEYWORD
   drop constraint FK_ASSOC_BOOK_KEYWORD_ASSOC_BOOK_KEYWORD2_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_CATEGORY_CATEGORY') and o.name = 'FK_ASSOC_CATEGORY_CATEGORY_ASSOC_CATEGORY_CATEGORY_CATEGORY')
alter table ASSOC_CATEGORY_CATEGORY
   drop constraint FK_ASSOC_CATEGORY_CATEGORY_ASSOC_CATEGORY_CATEGORY_CATEGORY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_CATEGORY_CATEGORY') and o.name = 'FK_ASSOC_CATEGORY_CATEGORY_ASSOC_CATEGORY_CATEGORY2_CATEGORY')
alter table ASSOC_CATEGORY_CATEGORY
   drop constraint FK_ASSOC_CATEGORY_CATEGORY_ASSOC_CATEGORY_CATEGORY2_CATEGORY
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_COMMENT_EMPLOYEE') and o.name = 'FK_ASSOC_COMMENT_EMPLOYEE_ASSOC_COMMENT_EMPLOYEE_EMPLOYEE')
alter table ASSOC_COMMENT_EMPLOYEE
   drop constraint FK_ASSOC_COMMENT_EMPLOYEE_ASSOC_COMMENT_EMPLOYEE_EMPLOYEE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_COMMENT_EMPLOYEE') and o.name = 'FK_ASSOC_COMMENT_EMPLOYEE_ASSOC_COMMENT_EMPLOYEE2_COMMENT')
alter table ASSOC_COMMENT_EMPLOYEE
   drop constraint FK_ASSOC_COMMENT_EMPLOYEE_ASSOC_COMMENT_EMPLOYEE2_COMMENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_CUSTOMER_BILLING_ADDRESS') and o.name = 'FK_ASSOC_CUSTOMER_BILLING_A_ASSOC_CUSTOMER_BILLING_A_CUSTOMER')
alter table ASSOC_CUSTOMER_BILLING_ADDRESS
   drop constraint FK_ASSOC_CUSTOMER_BILLING_A_ASSOC_CUSTOMER_BILLING_A_CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_CUSTOMER_BILLING_ADDRESS') and o.name = 'FK_ASSOC_CUSTOMER_BILLING_A_ASSOC_CUSTOMER_BILLING_A_ADDRESS')
alter table ASSOC_CUSTOMER_BILLING_ADDRESS
   drop constraint FK_ASSOC_CUSTOMER_BILLING_A_ASSOC_CUSTOMER_BILLING_A_ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_CUSTOMER_DELIVERY_ADDRESS') and o.name = 'FK_ASSOC_CUSTOMER_DELIVERY__ASSOC_CUSTOMER_DELIVERY__CUSTOMER')
alter table ASSOC_CUSTOMER_DELIVERY_ADDRESS
   drop constraint FK_ASSOC_CUSTOMER_DELIVERY__ASSOC_CUSTOMER_DELIVERY__CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_CUSTOMER_DELIVERY_ADDRESS') and o.name = 'FK_ASSOC_CUSTOMER_DELIVERY__ASSOC_CUSTOMER_DELIVERY__ADDRESS')
alter table ASSOC_CUSTOMER_DELIVERY_ADDRESS
   drop constraint FK_ASSOC_CUSTOMER_DELIVERY__ASSOC_CUSTOMER_DELIVERY__ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_GROUP_EMPLOYEE') and o.name = 'FK_ASSOC_GROUP_EMPLOYEE_ASSOC_GROUP_EMPLOYEE_EMPLOYEE')
alter table ASSOC_GROUP_EMPLOYEE
   drop constraint FK_ASSOC_GROUP_EMPLOYEE_ASSOC_GROUP_EMPLOYEE_EMPLOYEE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_GROUP_EMPLOYEE') and o.name = 'FK_ASSOC_GROUP_EMPLOYEE_ASSOC_GROUP_EMPLOYEE2_GROUP')
alter table ASSOC_GROUP_EMPLOYEE
   drop constraint FK_ASSOC_GROUP_EMPLOYEE_ASSOC_GROUP_EMPLOYEE2_GROUP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_ORDER_PACKAGE') and o.name = 'FK_ASSOC_ORDER_PACKAGE_ASSOC_ORDER_PACKAGE_ORDER')
alter table ASSOC_ORDER_PACKAGE
   drop constraint FK_ASSOC_ORDER_PACKAGE_ASSOC_ORDER_PACKAGE_ORDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_ORDER_PACKAGE') and o.name = 'FK_ASSOC_ORDER_PACKAGE_ASSOC_ORDER_PACKAGE2_PACKAGE')
alter table ASSOC_ORDER_PACKAGE
   drop constraint FK_ASSOC_ORDER_PACKAGE_ASSOC_ORDER_PACKAGE2_PACKAGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_PERMISSION_GROUP') and o.name = 'FK_ASSOC_PERMISSION_GROUP_ASSOC_PERMISSION_GROUP_PERMISSION')
alter table ASSOC_PERMISSION_GROUP
   drop constraint FK_ASSOC_PERMISSION_GROUP_ASSOC_PERMISSION_GROUP_PERMISSION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_PERMISSION_GROUP') and o.name = 'FK_ASSOC_PERMISSION_GROUP_ASSOC_PERMISSION_GROUP2_GROUP')
alter table ASSOC_PERMISSION_GROUP
   drop constraint FK_ASSOC_PERMISSION_GROUP_ASSOC_PERMISSION_GROUP2_GROUP
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_BOOK') and o.name = 'FK_ASSOC_STATUS_BOOK_ASSOC_STATUS_BOOK_BOOK_STATUS')
alter table ASSOC_STATUS_BOOK
   drop constraint FK_ASSOC_STATUS_BOOK_ASSOC_STATUS_BOOK_BOOK_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_BOOK') and o.name = 'FK_ASSOC_STATUS_BOOK_ASSOC_STATUS_BOOK2_BOOK')
alter table ASSOC_STATUS_BOOK
   drop constraint FK_ASSOC_STATUS_BOOK_ASSOC_STATUS_BOOK2_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_CARRIER') and o.name = 'FK_ASSOC_STATUS_CARRIER_ASSOC_STATUS_CARRIER_CARRIER_STATUS')
alter table ASSOC_STATUS_CARRIER
   drop constraint FK_ASSOC_STATUS_CARRIER_ASSOC_STATUS_CARRIER_CARRIER_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_CARRIER') and o.name = 'FK_ASSOC_STATUS_CARRIER_ASSOC_STATUS_CARRIER2_CARRIER')
alter table ASSOC_STATUS_CARRIER
   drop constraint FK_ASSOC_STATUS_CARRIER_ASSOC_STATUS_CARRIER2_CARRIER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_COMMENT') and o.name = 'FK_ASSOC_STATUS_COMMENT_ASSOC_STATUS_COMMENT_COMMENT')
alter table ASSOC_STATUS_COMMENT
   drop constraint FK_ASSOC_STATUS_COMMENT_ASSOC_STATUS_COMMENT_COMMENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_COMMENT') and o.name = 'FK_ASSOC_STATUS_COMMENT_ASSOC_STATUS_COMMENT2_COMMENT_STATUS')
alter table ASSOC_STATUS_COMMENT
   drop constraint FK_ASSOC_STATUS_COMMENT_ASSOC_STATUS_COMMENT2_COMMENT_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_CUSTOMER') and o.name = 'FK_ASSOC_STATUS_CUSTOMER_ASSOC_STATUS_CUSTOMER_CUSTOMER')
alter table ASSOC_STATUS_CUSTOMER
   drop constraint FK_ASSOC_STATUS_CUSTOMER_ASSOC_STATUS_CUSTOMER_CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_CUSTOMER') and o.name = 'FK_ASSOC_STATUS_CUSTOMER_ASSOC_STATUS_CUSTOMER2_CUSTOMER_STATUS')
alter table ASSOC_STATUS_CUSTOMER
   drop constraint FK_ASSOC_STATUS_CUSTOMER_ASSOC_STATUS_CUSTOMER2_CUSTOMER_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_ORDER') and o.name = 'FK_ASSOC_STATUS_ORDER_ASSOC_STATUS_ORDER_ORDER')
alter table ASSOC_STATUS_ORDER
   drop constraint FK_ASSOC_STATUS_ORDER_ASSOC_STATUS_ORDER_ORDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_ORDER') and o.name = 'FK_ASSOC_STATUS_ORDER_ASSOC_STATUS_ORDER2_ORDER_STATUS')
alter table ASSOC_STATUS_ORDER
   drop constraint FK_ASSOC_STATUS_ORDER_ASSOC_STATUS_ORDER2_ORDER_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_PACKAGE') and o.name = 'FK_ASSOC_STATUS_PACKAGE_ASSOC_STATUS_PACKAGE_PACKAGE_STATUS')
alter table ASSOC_STATUS_PACKAGE
   drop constraint FK_ASSOC_STATUS_PACKAGE_ASSOC_STATUS_PACKAGE_PACKAGE_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_PACKAGE') and o.name = 'FK_ASSOC_STATUS_PACKAGE_ASSOC_STATUS_PACKAGE2_PACKAGE')
alter table ASSOC_STATUS_PACKAGE
   drop constraint FK_ASSOC_STATUS_PACKAGE_ASSOC_STATUS_PACKAGE2_PACKAGE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_PAYMENT') and o.name = 'FK_ASSOC_STATUS_PAYMENT_ASSOC_STATUS_PAYMENT_PAYMENT')
alter table ASSOC_STATUS_PAYMENT
   drop constraint FK_ASSOC_STATUS_PAYMENT_ASSOC_STATUS_PAYMENT_PAYMENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ASSOC_STATUS_PAYMENT') and o.name = 'FK_ASSOC_STATUS_PAYMENT_ASSOC_STATUS_PAYMENT2_PAYMENT_STATUS')
alter table ASSOC_STATUS_PAYMENT
   drop constraint FK_ASSOC_STATUS_PAYMENT_ASSOC_STATUS_PAYMENT2_PAYMENT_STATUS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BOOK') and o.name = 'FK_BOOK_ASSOC_BOOK_PUBLISHER_PUBLISHER')
alter table BOOK
   drop constraint FK_BOOK_ASSOC_BOOK_PUBLISHER_PUBLISHER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('BOOK') and o.name = 'FK_BOOK_ASSOC_VAT_BOOK_VAT')
alter table BOOK
   drop constraint FK_BOOK_ASSOC_VAT_BOOK_VAT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARD_TYPE') and o.name = 'FK_CARD_TYPE_ASSOC_CARD_TYPE_PAYMENT__PAYMENT_ORGANIZATION')
alter table CARD_TYPE
   drop constraint FK_CARD_TYPE_ASSOC_CARD_TYPE_PAYMENT__PAYMENT_ORGANIZATION
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('CARRIER') and o.name = 'FK_CARRIER_ASSOC_ADDRESS_CARRIER_ADDRESS')
alter table CARRIER
   drop constraint FK_CARRIER_ASSOC_ADDRESS_CARRIER_ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMMENT') and o.name = 'FK_COMMENT_ASSOC_BOOK_COMMENT_BOOK')
alter table COMMENT
   drop constraint FK_COMMENT_ASSOC_BOOK_COMMENT_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMMENT') and o.name = 'FK_COMMENT_ASSOC_COMMAND_ROW_COMMEN_ORDER_ROW')
alter table COMMENT
   drop constraint FK_COMMENT_ASSOC_COMMAND_ROW_COMMEN_ORDER_ROW
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('COMMENT') and o.name = 'FK_COMMENT_ASSOC_COMMENT_CUSTOMER_CUSTOMER')
alter table COMMENT
   drop constraint FK_COMMENT_ASSOC_COMMENT_CUSTOMER_CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"ORDER"') and o.name = 'FK_ORDER_ASSOC_ORDER_BILLING_ADDR_ADDRESS')
alter table "ORDER"
   drop constraint FK_ORDER_ASSOC_ORDER_BILLING_ADDR_ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"ORDER"') and o.name = 'FK_ORDER_ASSOC_ORDER_CUSTOMER_CUSTOMER')
alter table "ORDER"
   drop constraint FK_ORDER_ASSOC_ORDER_CUSTOMER_CUSTOMER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"ORDER"') and o.name = 'FK_ORDER_ASSOC_ORDER_DELIVERY_ADD_ADDRESS')
alter table "ORDER"
   drop constraint FK_ORDER_ASSOC_ORDER_DELIVERY_ADD_ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('"ORDER"') and o.name = 'FK_ORDER_ASSOC_SHIPPING_OFFER_ORD_SHIPPING_OFFER')
alter table "ORDER"
   drop constraint FK_ORDER_ASSOC_SHIPPING_OFFER_ORD_SHIPPING_OFFER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORDER_ROW') and o.name = 'FK_ORDER_ROW_ASSOC_BOOK_ORDER_ROW_BOOK')
alter table ORDER_ROW
   drop constraint FK_ORDER_ROW_ASSOC_BOOK_ORDER_ROW_BOOK
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORDER_ROW') and o.name = 'FK_ORDER_ROW_ASSOC_COMMAND_ROW_COMMEN_COMMENT')
alter table ORDER_ROW
   drop constraint FK_ORDER_ROW_ASSOC_COMMAND_ROW_COMMEN_COMMENT
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('ORDER_ROW') and o.name = 'FK_ORDER_ROW_ASSOC_ORDER_ROW_ORDER_ORDER')
alter table ORDER_ROW
   drop constraint FK_ORDER_ROW_ASSOC_ORDER_ROW_ORDER_ORDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PAYMENT') and o.name = 'FK_PAYMENT_ASSOC_PAYMENT_CARD_TYPE_CARD_TYPE')
alter table PAYMENT
   drop constraint FK_PAYMENT_ASSOC_PAYMENT_CARD_TYPE_CARD_TYPE
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PAYMENT') and o.name = 'FK_PAYMENT_ASSOC_PAYMENT_ORDER_ORDER')
alter table PAYMENT
   drop constraint FK_PAYMENT_ASSOC_PAYMENT_ORDER_ORDER
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('PAYMENT_ORGANIZATION') and o.name = 'FK_PAYMENT_ORGANIZATION_ASSOC_ADDRESS_PAYEMENT_O_ADDRESS')
alter table PAYMENT_ORGANIZATION
   drop constraint FK_PAYMENT_ORGANIZATION_ASSOC_ADDRESS_PAYEMENT_O_ADDRESS
go

if exists (select 1
   from sys.sysreferences r join sys.sysobjects o on (o.id = r.constid and o.type = 'F')
   where r.fkeyid = object_id('SHIPPING_OFFER') and o.name = 'FK_SHIPPING_OFFER_ASSOC_CARRIER_SHIPPING_O_CARRIER')
alter table SHIPPING_OFFER
   drop constraint FK_SHIPPING_OFFER_ASSOC_CARRIER_SHIPPING_O_CARRIER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ADDRESS')
            and   type = 'U')
   drop table ADDRESS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_ADDRESS_PUBLISHER')
            and   type = 'U')
   drop table ASSOC_ADDRESS_PUBLISHER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_BOOK_AUTHOR')
            and   type = 'U')
   drop table ASSOC_BOOK_AUTHOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_BOOK_CATEGORY')
            and   type = 'U')
   drop table ASSOC_BOOK_CATEGORY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_BOOK_EVENT')
            and   type = 'U')
   drop table ASSOC_BOOK_EVENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_BOOK_KEYWORD')
            and   type = 'U')
   drop table ASSOC_BOOK_KEYWORD
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_CATEGORY_CATEGORY')
            and   type = 'U')
   drop table ASSOC_CATEGORY_CATEGORY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_COMMENT_EMPLOYEE')
            and   type = 'U')
   drop table ASSOC_COMMENT_EMPLOYEE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_CUSTOMER_BILLING_ADDRESS')
            and   type = 'U')
   drop table ASSOC_CUSTOMER_BILLING_ADDRESS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_CUSTOMER_DELIVERY_ADDRESS')
            and   type = 'U')
   drop table ASSOC_CUSTOMER_DELIVERY_ADDRESS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_GROUP_EMPLOYEE')
            and   type = 'U')
   drop table ASSOC_GROUP_EMPLOYEE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_ORDER_PACKAGE')
            and   type = 'U')
   drop table ASSOC_ORDER_PACKAGE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_PERMISSION_GROUP')
            and   type = 'U')
   drop table ASSOC_PERMISSION_GROUP
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_BOOK')
            and   type = 'U')
   drop table ASSOC_STATUS_BOOK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_CARRIER')
            and   type = 'U')
   drop table ASSOC_STATUS_CARRIER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_COMMENT')
            and   type = 'U')
   drop table ASSOC_STATUS_COMMENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_CUSTOMER')
            and   type = 'U')
   drop table ASSOC_STATUS_CUSTOMER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_ORDER')
            and   type = 'U')
   drop table ASSOC_STATUS_ORDER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_PACKAGE')
            and   type = 'U')
   drop table ASSOC_STATUS_PACKAGE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ASSOC_STATUS_PAYMENT')
            and   type = 'U')
   drop table ASSOC_STATUS_PAYMENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ATTRIBUTE')
            and   type = 'U')
   drop table ATTRIBUTE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('AUTHOR')
            and   type = 'U')
   drop table AUTHOR
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BOOK')
            and   type = 'U')
   drop table BOOK
go

if exists (select 1
            from  sysobjects
           where  id = object_id('BOOK_STATUS')
            and   type = 'U')
   drop table BOOK_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARD_TYPE')
            and   type = 'U')
   drop table CARD_TYPE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARRIER')
            and   type = 'U')
   drop table CARRIER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CARRIER_STATUS')
            and   type = 'U')
   drop table CARRIER_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CATEGORY')
            and   type = 'U')
   drop table CATEGORY
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COMMENT')
            and   type = 'U')
   drop table COMMENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('COMMENT_STATUS')
            and   type = 'U')
   drop table COMMENT_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUSTOMER')
            and   type = 'U')
   drop table CUSTOMER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('CUSTOMER_STATUS')
            and   type = 'U')
   drop table CUSTOMER_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EMPLOYEE')
            and   type = 'U')
   drop table EMPLOYEE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('EVENT')
            and   type = 'U')
   drop table EVENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"GROUP"')
            and   type = 'U')
   drop table "GROUP"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('KEYWORD')
            and   type = 'U')
   drop table KEYWORD
go

if exists (select 1
            from  sysobjects
           where  id = object_id('"ORDER"')
            and   type = 'U')
   drop table "ORDER"
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ORDER_ROW')
            and   type = 'U')
   drop table ORDER_ROW
go

if exists (select 1
            from  sysobjects
           where  id = object_id('ORDER_STATUS')
            and   type = 'U')
   drop table ORDER_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PACKAGE')
            and   type = 'U')
   drop table PACKAGE
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PACKAGE_STATUS')
            and   type = 'U')
   drop table PACKAGE_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PAYMENT')
            and   type = 'U')
   drop table PAYMENT
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PAYMENT_ORGANIZATION')
            and   type = 'U')
   drop table PAYMENT_ORGANIZATION
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PAYMENT_STATUS')
            and   type = 'U')
   drop table PAYMENT_STATUS
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PERMISSION')
            and   type = 'U')
   drop table PERMISSION
go

if exists (select 1
            from  sysobjects
           where  id = object_id('PUBLISHER')
            and   type = 'U')
   drop table PUBLISHER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('SHIPPING_OFFER')
            and   type = 'U')
   drop table SHIPPING_OFFER
go

if exists (select 1
            from  sysobjects
           where  id = object_id('VAT')
            and   type = 'U')
   drop table VAT
go

/*==============================================================*/
/* Table : ADDRESS                                              */
/*==============================================================*/
create table ADDRESS (
   ADDRESS_ID           numeric              identity,
   ADDRESS_COMPANY_NAME varchar(50)          null,
   ADDRESS_L_NAME       varchar(50)          null,
   ADDRESS_F_NAME       varchar(50)          null,
   ADDRESS_STREET       varchar(80)          not null,
   ADDRESS_STREET_EXTRA varchar(80)          null,
   ADDRESS_POSTCODE     char(5)              not null,
   ADDRESS_CITY         varchar(50)          not null,
   ADDRESS_PHONE        varchar(15)          null,
   ADDRESS_PHONE_EXTRA  varchar(15)          null,
   constraint PK_ADDRESS primary key nonclustered (ADDRESS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_ADDRESS_PUBLISHER                              */
/*==============================================================*/
create table ASSOC_ADDRESS_PUBLISHER (
   PUBLISHER_ID         numeric              not null,
   ADDRESS_ID           numeric              not null,
   constraint PK_ASSOC_ADDRESS_PUBLISHER primary key nonclustered (PUBLISHER_ID, ADDRESS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_BOOK_AUTHOR                                    */
/*==============================================================*/
create table ASSOC_BOOK_AUTHOR (
   AUTHOR_ID            numeric              not null,
   BOOK_ISBN            char(13)             not null,
   constraint PK_ASSOC_BOOK_AUTHOR primary key nonclustered (AUTHOR_ID, BOOK_ISBN)
)
go

/*==============================================================*/
/* Table : ASSOC_BOOK_CATEGORY                                  */
/*==============================================================*/
create table ASSOC_BOOK_CATEGORY (
   BOOK_ISBN            char(13)             not null,
   CATEGORY_ID          numeric(8)           not null,
   constraint PK_ASSOC_BOOK_CATEGORY primary key nonclustered (BOOK_ISBN, CATEGORY_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_BOOK_EVENT                                     */
/*==============================================================*/
create table ASSOC_BOOK_EVENT (
   EVENT_ID             numeric              not null,
   BOOK_ISBN            char(13)             not null,
   constraint PK_ASSOC_BOOK_EVENT primary key nonclustered (EVENT_ID, BOOK_ISBN)
)
go

/*==============================================================*/
/* Table : ASSOC_BOOK_KEYWORD                                   */
/*==============================================================*/
create table ASSOC_BOOK_KEYWORD (
   KEYWORD_ID           numeric              not null,
   BOOK_ISBN            char(13)             not null,
   constraint PK_ASSOC_BOOK_KEYWORD primary key nonclustered (KEYWORD_ID, BOOK_ISBN)
)
go

/*==============================================================*/
/* Table : ASSOC_CATEGORY_CATEGORY                              */
/*==============================================================*/
create table ASSOC_CATEGORY_CATEGORY (
   CATEGORY_PARENT_ID   numeric(8)           not null,
   CATEGORY_CHILD_ID    numeric(8)           not null,
   constraint PK_ASSOC_CATEGORY_CATEGORY primary key nonclustered (CATEGORY_PARENT_ID, CATEGORY_CHILD_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_COMMENT_EMPLOYEE                               */
/*==============================================================*/
create table ASSOC_COMMENT_EMPLOYEE (
   EMPLOYEE_ID          numeric              not null,
   COMMENT_ID           numeric              not null,
   ASSOC_COMMENT_EMPLOYEE_DATE datetime             not null,
   ASSOC_COMMENT_EMPLOYEE_POST_IT varchar(500)         not null,
   constraint PK_ASSOC_COMMENT_EMPLOYEE primary key nonclustered (EMPLOYEE_ID, COMMENT_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_CUSTOMER_BILLING_ADDRESS                       */
/*==============================================================*/
create table ASSOC_CUSTOMER_BILLING_ADDRESS (
   CUSTOMER_ID          numeric              not null,
   ADDRESS_ID           numeric              not null,
   constraint PK_ASSOC_CUSTOMER_BILLING_ADDR primary key nonclustered (CUSTOMER_ID, ADDRESS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_CUSTOMER_DELIVERY_ADDRESS                      */
/*==============================================================*/
create table ASSOC_CUSTOMER_DELIVERY_ADDRESS (
   CUSTOMER_ID          numeric              not null,
   ADDRESS_ID           numeric              not null,
   constraint PK_ASSOC_CUSTOMER_DELIVERY_ADD primary key nonclustered (CUSTOMER_ID, ADDRESS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_GROUP_EMPLOYEE                                 */
/*==============================================================*/
create table ASSOC_GROUP_EMPLOYEE (
   EMPLOYEE_ID          numeric              not null,
   GROUP_ID             int                  not null,
   constraint PK_ASSOC_GROUP_EMPLOYEE primary key nonclustered (EMPLOYEE_ID, GROUP_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_ORDER_PACKAGE                                  */
/*==============================================================*/
create table ASSOC_ORDER_PACKAGE (
   ORDER_ID             numeric              not null,
   PACKAGE_ID           numeric              not null,
   constraint PK_ASSOC_ORDER_PACKAGE primary key nonclustered (ORDER_ID, PACKAGE_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_PERMISSION_GROUP                               */
/*==============================================================*/
create table ASSOC_PERMISSION_GROUP (
   PERMISSION_ID        int                  not null,
   GROUP_ID             int                  not null,
   constraint PK_ASSOC_PERMISSION_GROUP primary key nonclustered (PERMISSION_ID, GROUP_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_BOOK                                    */
/*==============================================================*/
create table ASSOC_STATUS_BOOK (
   BOOK_STATUS_ID       numeric              not null,
   BOOK_ISBN            char(13)             not null,
   ASSOC_STATUS_BOOK_DATE datetime             null,
   ASSOC_STATUS_BOOK_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_BOOK primary key nonclustered (BOOK_STATUS_ID, BOOK_ISBN)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_CARRIER                                 */
/*==============================================================*/
create table ASSOC_STATUS_CARRIER (
   CARRIER_STATUS_ID    numeric              not null,
   CARRIER_ID           numeric              not null,
   ASSOC_STATUS_CARRIER_DATE datetime             null,
   ASSOC_STATUS_CARRIER_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_CARRIER primary key nonclustered (CARRIER_STATUS_ID, CARRIER_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_COMMENT                                 */
/*==============================================================*/
create table ASSOC_STATUS_COMMENT (
   COMMENT_ID           numeric              not null,
   COMMENT_STATUS_ID    numeric              not null,
   ASSOC_STATUS_COMMENT_DATE datetime             not null,
   ASSOC_STATUS_COMMENT_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_COMMENT primary key nonclustered (COMMENT_ID, COMMENT_STATUS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_CUSTOMER                                */
/*==============================================================*/
create table ASSOC_STATUS_CUSTOMER (
   CUSTOMER_ID          numeric              not null,
   CUSTOMER_STATUS_ID   int                  not null,
   ASSOC_STATUS_CLIENT_DATE datetime             null,
   ASSOC_STATUS_CLIENT_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_CUSTOMER primary key nonclustered (CUSTOMER_ID, CUSTOMER_STATUS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_ORDER                                   */
/*==============================================================*/
create table ASSOC_STATUS_ORDER (
   ORDER_ID             numeric              not null,
   ORDER_STATUS_ID      int                  not null,
   ASSOC_STATUS_ORDER_DATE datetime             not null,
   ASSOC_STATUS_ORDER_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_ORDER primary key nonclustered (ORDER_ID, ORDER_STATUS_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_PACKAGE                                 */
/*==============================================================*/
create table ASSOC_STATUS_PACKAGE (
   PACKAGE_STATUS_ID    numeric              not null,
   PACKAGE_ID           numeric              not null,
   ASSOC_STATUS_PACKAGE_DATE datetime             not null,
   ASSOC_STATUS_PACKAGE_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_PACKAGE primary key nonclustered (PACKAGE_STATUS_ID, PACKAGE_ID)
)
go

/*==============================================================*/
/* Table : ASSOC_STATUS_PAYMENT                                 */
/*==============================================================*/
create table ASSOC_STATUS_PAYMENT (
   PAYMENT_ID           numeric              not null,
   PAYMENT_SUB_ID       varchar(25)          not null,
   PAYMENT_STATUS_ID    numeric              not null,
   ASSOC_STATUS_PAYMENT_DATE datetime             not null,
   ASSOC_STATUS_PAYMENT_POST_IT varchar(500)         null,
   constraint PK_ASSOC_STATUS_PAYMENT primary key nonclustered (PAYMENT_ID, PAYMENT_SUB_ID, PAYMENT_STATUS_ID)
)
go

/*==============================================================*/
/* Table : ATTRIBUTE                                            */
/*==============================================================*/
create table ATTRIBUTE (
   ATTRIBUTE_KEY        varchar(50)          not null,
   ATTRIBUTE_VALUE      varchar(50)          not null,
   constraint PK_ATTRIBUTE primary key nonclustered (ATTRIBUTE_KEY)
)
go

/*==============================================================*/
/* Table : AUTHOR                                               */
/*==============================================================*/
create table AUTHOR (
   AUTHOR_ID            numeric              identity,
   AUTHOR_L_NAME        varchar(50)          not null,
   AUTHOR_F_NAME        varchar(50)          null,
   AUTHOR_POST_IT       varchar(500)         null,
   constraint PK_AUTHOR primary key nonclustered (AUTHOR_ID)
)
go

/*==============================================================*/
/* Table : BOOK                                                 */
/*==============================================================*/
create table BOOK (
   BOOK_ISBN            char(13)             not null,
   PUBLISHER_ID         numeric              not null,
   VAT_ID               numeric              not null,
   BOOK_TITLE           varchar(70)          not null,
   BOOK_SUBTITLE        varchar(70)          null,
   BOOK_HT_PRICE        decimal(5,2)         not null,
   BOOK_COVER_URL       varchar(100)         not null,
   BOOK_SUMMARY         varchar(500)         null,
   BOOK_STOCK_QTY       int                  not null,
   BOOK_SHELF           varchar(50)          not null,
   BOOK_POST_IT         varchar(500)         null,
   constraint PK_BOOK primary key nonclustered (BOOK_ISBN)
)
go

/*==============================================================*/
/* Table : BOOK_STATUS                                          */
/*==============================================================*/
create table BOOK_STATUS (
   BOOK_STATUS_ID       numeric              identity,
   BOOK_STATUS_NAME     varchar(50)          not null,
   BOOK_STATUS_POST_IT  varchar(500)         null,
   constraint PK_BOOK_STATUS primary key nonclustered (BOOK_STATUS_ID)
)
go

/*==============================================================*/
/* Table : CARD_TYPE                                            */
/*==============================================================*/
create table CARD_TYPE (
   CARD_TYPE_ID         numeric              identity,
   PAYMENT_ORGANIZATION_ID numeric              not null,
   CARD_TYPE_NAME       varchar(50)          not null,
   CARD_TYPE_LOGO_URL   varchar(100)         not null,
   constraint PK_CARD_TYPE primary key nonclustered (CARD_TYPE_ID)
)
go

/*==============================================================*/
/* Table : CARRIER                                              */
/*==============================================================*/
create table CARRIER (
   CARRIER_ID           numeric              identity,
   ADDRESS_ID           numeric              not null,
   CARRIER_CORPORATE_NAME varchar(150)         not null,
   CARRIER_EMAIL        varchar(50)          not null,
   constraint PK_CARRIER primary key nonclustered (CARRIER_ID)
)
go

/*==============================================================*/
/* Table : CARRIER_STATUS                                       */
/*==============================================================*/
create table CARRIER_STATUS (
   CARRIER_STATUS_ID    numeric              identity,
   CARRIER_STATUS_NAME  varchar(20)          not null,
   CARRIER_STATUS_POST_IT varchar(500)         null,
   constraint PK_CARRIER_STATUS primary key nonclustered (CARRIER_STATUS_ID)
)
go

/*==============================================================*/
/* Table : CATEGORY                                             */
/*==============================================================*/
create table CATEGORY (
   CATEGORY_ID          numeric(8)           identity,
   CATEGORY_NAME        varchar(50)          not null,
   constraint PK_CATEGORY primary key nonclustered (CATEGORY_ID)
)
go

/*==============================================================*/
/* Table : COMMENT                                              */
/*==============================================================*/
create table COMMENT (
   COMMENT_ID           numeric              identity,
   CUSTOMER_ID          numeric              not null,
   ORDER_ROW_ID         numeric              not null,
   BOOK_ISBN            char(13)             not null,
   COMMENT_TITLE        varchar(100)         not null,
   COMMENT_RATING       smallint             not null,
   COMMENT_TEXT         varchar(500)         not null,
   COMMENT_DATE         datetime             not null,
   COMMENT_USER_IP      varchar(45)          not null,
   COMMENT_EDIT_DATE    datetime             null,
   constraint PK_COMMENT primary key nonclustered (COMMENT_ID)
)
go

/*==============================================================*/
/* Table : COMMENT_STATUS                                       */
/*==============================================================*/
create table COMMENT_STATUS (
   COMMENT_STATUS_ID    numeric              identity,
   COMMENT_STATUS_NAME  varchar(20)          not null,
   COMMENT_STATUS_POST_IT varchar(500)         null,
   constraint PK_COMMENT_STATUS primary key nonclustered (COMMENT_STATUS_ID)
)
go

/*==============================================================*/
/* Table : CUSTOMER                                             */
/*==============================================================*/
create table CUSTOMER (
   CUSTOMER_ID          numeric              identity,
   CUSTOMER_L_NAME      varchar(50)          not null,
   CUSTOMER_F_NAME      varchar(50)          not null,
   CUSTOMER_EMAIL       varchar(50)          not null,
   CUSTOMER_USERNAME    varchar(20)          null,
   CUSTOMER_PASSWORD    varchar(64)          not null,
   CUSTOMER_POST_IT     varchar(500)         null,
   CLIENT_DATE          datetime             null,
   constraint PK_CUSTOMER primary key nonclustered (CUSTOMER_ID)
)
go

/*==============================================================*/
/* Table : CUSTOMER_STATUS                                      */
/*==============================================================*/
create table CUSTOMER_STATUS (
   CUSTOMER_STATUS_ID   int                  not null,
   CUSTOMER_STATUS_NAME varchar(20)          not null,
   STATUT_CLIENT_DATE_DEB datetime             not null,
   CUSTOMER_STATUS_POST_IT varchar(500)         null,
   constraint PK_CUSTOMER_STATUS primary key nonclustered (CUSTOMER_STATUS_ID)
)
go

/*==============================================================*/
/* Table : EMPLOYEE                                             */
/*==============================================================*/
create table EMPLOYEE (
   EMPLOYEE_ID          numeric              identity,
   EMPLOYEE_LOGIN       varchar(20)          not null,
   EMPLOYEE_PASSWORD    varchar(20)          not null,
   EMPLOYEE_DATE_START  datetime             not null,
   EMPLOYEE_DATE_END    datetime             not null,
   constraint PK_EMPLOYEE primary key nonclustered (EMPLOYEE_ID)
)
go

/*==============================================================*/
/* Table : EVENT                                                */
/*==============================================================*/
create table EVENT (
   EVENT_ID             numeric              identity,
   EVENT_NAME           varchar(80)          not null,
   EVENT_DATE_START     datetime             not null,
   EVENT_DATE_END       datetime             not null,
   EVENT_DISCOUNT_VALUE decimal(5,2)         not null,
   EVENT_IMAGE_URL      varchar(100)         null,
   constraint PK_EVENT primary key nonclustered (EVENT_ID)
)
go

/*==============================================================*/
/* Table : "GROUP"                                              */
/*==============================================================*/
create table "GROUP" (
   GROUP_ID             int                  not null,
   GROUP_NAME           varchar(20)          not null,
   constraint PK_GROUP primary key nonclustered (GROUP_ID)
)
go

/*==============================================================*/
/* Table : KEYWORD                                              */
/*==============================================================*/
create table KEYWORD (
   KEYWORD_ID           numeric              identity,
   KEYWORD_NAME         varchar(50)          not null,
   constraint PK_KEYWORD primary key nonclustered (KEYWORD_ID)
)
go

/*==============================================================*/
/* Table : "ORDER"                                              */
/*==============================================================*/
create table "ORDER" (
   ORDER_ID             numeric              identity,
   CUSTOMER_ID          numeric              not null,
   DELIVERY_ADDRESS_ID  numeric              not null,
   BILLING_ADDRESS_ID   numeric              not null,
   SHIPPING_OFFER_ID    numeric              not null,
   ORDER_CREATION_DATE  datetime             not null,
   ORDER_SHIPPING_TIME_LIMIT varchar(20)          not null,
   ORDER_USER_IP        varchar(45)          not null,
   ORDER_COMMENT        varchar(200)         null,
   ASSOC_SHIPPING_OFFER_COMMAND_HT_PRICE decimal(7,2)         not null,
   constraint PK_ORDER primary key nonclustered (ORDER_ID)
)
go

/*==============================================================*/
/* Table : ORDER_ROW                                            */
/*==============================================================*/
create table ORDER_ROW (
   ORDER_ROW_ID         numeric              identity,
   COMMENT_ID           numeric              null,
   ORDER_ID             numeric              not null,
   BOOK_ISBN            char(13)             not null,
   ORDER_ROW_QTY        int                  not null,
   ORDER_ROW_HT_PRICE   decimal(7,2)         not null,
   ORDER_ROW_DISCOUNT_VALUE decimal(5,2)         null,
   constraint PK_ORDER_ROW primary key nonclustered (ORDER_ROW_ID)
)
go

/*==============================================================*/
/* Table : ORDER_STATUS                                         */
/*==============================================================*/
create table ORDER_STATUS (
   ORDER_STATUS_ID      int                  not null,
   ORDER_STATUS_NAME    varchar(50)          not null,
   ORDER_STATUS_POST_IT varchar(500)         not null,
   constraint PK_ORDER_STATUS primary key nonclustered (ORDER_STATUS_ID)
)
go

/*==============================================================*/
/* Table : PACKAGE                                              */
/*==============================================================*/
create table PACKAGE (
   PACKAGE_ID           numeric              identity,
   PACKAGE_TRACKING_NUMBER varchar(50)          not null,
   PACKAGE_SHIPPING_DATE datetime             not null,
   PACKAGE_POST_IT      varchar(500)         null,
   constraint PK_PACKAGE primary key nonclustered (PACKAGE_ID)
)
go

/*==============================================================*/
/* Table : PACKAGE_STATUS                                       */
/*==============================================================*/
create table PACKAGE_STATUS (
   PACKAGE_STATUS_ID    numeric              identity,
   PACKAGE_STATUS_NAME  varchar(100)         not null,
   constraint PK_PACKAGE_STATUS primary key nonclustered (PACKAGE_STATUS_ID)
)
go

/*==============================================================*/
/* Table : PAYMENT                                              */
/*==============================================================*/
create table PAYMENT (
   PAYMENT_ID           numeric              identity,
   PAYMENT_SUB_ID       varchar(25)          not null,
   ORDER_ID             numeric              not null,
   CARD_TYPE_ID         numeric              not null,
   ASSOC_PAYMENT_ORDER_DATE datetime             not null,
   ASSOC_PAYMENT_ORDER_POST_IT varchar(500)         null,
   constraint PK_PAYMENT primary key nonclustered (PAYMENT_ID, PAYMENT_SUB_ID)
)
go

/*==============================================================*/
/* Table : PAYMENT_ORGANIZATION                                 */
/*==============================================================*/
create table PAYMENT_ORGANIZATION (
   PAYMENT_ORGANIZATION_ID numeric              identity,
   ADDRESS_ID           numeric              not null,
   PAYMENT_ORGANIZATION_NAME varchar(100)         not null,
   constraint PK_PAYMENT_ORGANIZATION primary key nonclustered (PAYMENT_ORGANIZATION_ID)
)
go

/*==============================================================*/
/* Table : PAYMENT_STATUS                                       */
/*==============================================================*/
create table PAYMENT_STATUS (
   PAYMENT_STATUS_ID    numeric              identity,
   PAYMENT_STATUS_NAME  char(50)             not null,
   PAYMENT_STATUS_POST_IT varchar(500)         null,
   constraint PK_PAYMENT_STATUS primary key nonclustered (PAYMENT_STATUS_ID)
)
go

/*==============================================================*/
/* Table : PERMISSION                                           */
/*==============================================================*/
create table PERMISSION (
   PERMISSION_ID        int                  not null,
   PERMISSION_NAME      varchar(20)          not null,
   constraint PK_PERMISSION primary key nonclustered (PERMISSION_ID)
)
go

/*==============================================================*/
/* Table : PUBLISHER                                            */
/*==============================================================*/
create table PUBLISHER (
   PUBLISHER_ID         numeric              identity,
   PUBLISHER_NAME       varchar(50)          not null,
   PUBLISHER_POST_IT    varchar(500)         null,
   constraint PK_PUBLISHER primary key nonclustered (PUBLISHER_ID)
)
go

/*==============================================================*/
/* Table : SHIPPING_OFFER                                       */
/*==============================================================*/
create table SHIPPING_OFFER (
   SHIPPING_OFFER_ID    numeric              identity,
   CARRIER_ID           numeric              not null,
   SHIPPING_OFFER_NAME  varchar(60)          not null,
   SHIPPING_OFFER_DETAILS varchar(150)         null,
   SHIPPING_OFFER_CONDITIONS varchar(150)         not null,
   SHIPPING_OFFER_HT_PRICE decimal(7,2)         not null,
   SHIPPING_OFFER_POST_IT varchar(500)         null,
   constraint PK_SHIPPING_OFFER primary key nonclustered (SHIPPING_OFFER_ID)
)
go

/*==============================================================*/
/* Table : VAT                                                  */
/*==============================================================*/
create table VAT (
   VAT_ID               numeric              identity,
   VAT_RATE             decimal(5,2)         not null,
   constraint PK_VAT primary key nonclustered (VAT_ID)
)
go

alter table ASSOC_ADDRESS_PUBLISHER
   add constraint FK_ASSOC_ADDRESS_PUBLISHER_ASSOC_ADDRESS_PUBLISHER_PUBLISHER foreign key (PUBLISHER_ID)
      references PUBLISHER (PUBLISHER_ID)
go

alter table ASSOC_ADDRESS_PUBLISHER
   add constraint FK_ASSOC_ADDRESS_PUBLISHER_ASSOC_ADDRESS_PUBLISHER2_ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table ASSOC_BOOK_AUTHOR
   add constraint FK_ASSOC_BOOK_AUTHOR_ASSOC_BOOK_AUTHOR_AUTHOR foreign key (AUTHOR_ID)
      references AUTHOR (AUTHOR_ID)
go

alter table ASSOC_BOOK_AUTHOR
   add constraint FK_ASSOC_BOOK_AUTHOR_ASSOC_BOOK_AUTHOR2_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table ASSOC_BOOK_CATEGORY
   add constraint FK_ASSOC_BOOK_CATEGORY_ASSOC_BOOK_CATEGORY_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table ASSOC_BOOK_CATEGORY
   add constraint FK_ASSOC_BOOK_CATEGORY_ASSOC_BOOK_CATEGORY2_CATEGORY foreign key (CATEGORY_ID)
      references CATEGORY (CATEGORY_ID)
go

alter table ASSOC_BOOK_EVENT
   add constraint FK_ASSOC_BOOK_EVENT_ASSOC_BOOK_EVENT_EVENT foreign key (EVENT_ID)
      references EVENT (EVENT_ID)
go

alter table ASSOC_BOOK_EVENT
   add constraint FK_ASSOC_BOOK_EVENT_ASSOC_BOOK_EVENT2_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table ASSOC_BOOK_KEYWORD
   add constraint FK_ASSOC_BOOK_KEYWORD_ASSOC_BOOK_KEYWORD_KEYWORD foreign key (KEYWORD_ID)
      references KEYWORD (KEYWORD_ID)
go

alter table ASSOC_BOOK_KEYWORD
   add constraint FK_ASSOC_BOOK_KEYWORD_ASSOC_BOOK_KEYWORD2_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table ASSOC_CATEGORY_CATEGORY
   add constraint FK_ASSOC_CATEGORY_CATEGORY_ASSOC_CATEGORY_CATEGORY_CATEGORY foreign key (CATEGORY_PARENT_ID)
      references CATEGORY (CATEGORY_ID)
go

alter table ASSOC_CATEGORY_CATEGORY
   add constraint FK_ASSOC_CATEGORY_CATEGORY_ASSOC_CATEGORY_CATEGORY2_CATEGORY foreign key (CATEGORY_CHILD_ID)
      references CATEGORY (CATEGORY_ID)
go

alter table ASSOC_COMMENT_EMPLOYEE
   add constraint FK_ASSOC_COMMENT_EMPLOYEE_ASSOC_COMMENT_EMPLOYEE_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (EMPLOYEE_ID)
go

alter table ASSOC_COMMENT_EMPLOYEE
   add constraint FK_ASSOC_COMMENT_EMPLOYEE_ASSOC_COMMENT_EMPLOYEE2_COMMENT foreign key (COMMENT_ID)
      references COMMENT (COMMENT_ID)
go

alter table ASSOC_CUSTOMER_BILLING_ADDRESS
   add constraint FK_ASSOC_CUSTOMER_BILLING_A_ASSOC_CUSTOMER_BILLING_A_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID)
go

alter table ASSOC_CUSTOMER_BILLING_ADDRESS
   add constraint FK_ASSOC_CUSTOMER_BILLING_A_ASSOC_CUSTOMER_BILLING_A_ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table ASSOC_CUSTOMER_DELIVERY_ADDRESS
   add constraint FK_ASSOC_CUSTOMER_DELIVERY__ASSOC_CUSTOMER_DELIVERY__CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID)
go

alter table ASSOC_CUSTOMER_DELIVERY_ADDRESS
   add constraint FK_ASSOC_CUSTOMER_DELIVERY__ASSOC_CUSTOMER_DELIVERY__ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table ASSOC_GROUP_EMPLOYEE
   add constraint FK_ASSOC_GROUP_EMPLOYEE_ASSOC_GROUP_EMPLOYEE_EMPLOYEE foreign key (EMPLOYEE_ID)
      references EMPLOYEE (EMPLOYEE_ID)
go

alter table ASSOC_GROUP_EMPLOYEE
   add constraint FK_ASSOC_GROUP_EMPLOYEE_ASSOC_GROUP_EMPLOYEE2_GROUP foreign key (GROUP_ID)
      references "GROUP" (GROUP_ID)
go

alter table ASSOC_ORDER_PACKAGE
   add constraint FK_ASSOC_ORDER_PACKAGE_ASSOC_ORDER_PACKAGE_ORDER foreign key (ORDER_ID)
      references "ORDER" (ORDER_ID)
go

alter table ASSOC_ORDER_PACKAGE
   add constraint FK_ASSOC_ORDER_PACKAGE_ASSOC_ORDER_PACKAGE2_PACKAGE foreign key (PACKAGE_ID)
      references PACKAGE (PACKAGE_ID)
go

alter table ASSOC_PERMISSION_GROUP
   add constraint FK_ASSOC_PERMISSION_GROUP_ASSOC_PERMISSION_GROUP_PERMISSION foreign key (PERMISSION_ID)
      references PERMISSION (PERMISSION_ID)
go

alter table ASSOC_PERMISSION_GROUP
   add constraint FK_ASSOC_PERMISSION_GROUP_ASSOC_PERMISSION_GROUP2_GROUP foreign key (GROUP_ID)
      references "GROUP" (GROUP_ID)
go

alter table ASSOC_STATUS_BOOK
   add constraint FK_ASSOC_STATUS_BOOK_ASSOC_STATUS_BOOK_BOOK_STATUS foreign key (BOOK_STATUS_ID)
      references BOOK_STATUS (BOOK_STATUS_ID)
go

alter table ASSOC_STATUS_BOOK
   add constraint FK_ASSOC_STATUS_BOOK_ASSOC_STATUS_BOOK2_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table ASSOC_STATUS_CARRIER
   add constraint FK_ASSOC_STATUS_CARRIER_ASSOC_STATUS_CARRIER_CARRIER_STATUS foreign key (CARRIER_STATUS_ID)
      references CARRIER_STATUS (CARRIER_STATUS_ID)
go

alter table ASSOC_STATUS_CARRIER
   add constraint FK_ASSOC_STATUS_CARRIER_ASSOC_STATUS_CARRIER2_CARRIER foreign key (CARRIER_ID)
      references CARRIER (CARRIER_ID)
go

alter table ASSOC_STATUS_COMMENT
   add constraint FK_ASSOC_STATUS_COMMENT_ASSOC_STATUS_COMMENT_COMMENT foreign key (COMMENT_ID)
      references COMMENT (COMMENT_ID)
go

alter table ASSOC_STATUS_COMMENT
   add constraint FK_ASSOC_STATUS_COMMENT_ASSOC_STATUS_COMMENT2_COMMENT_STATUS foreign key (COMMENT_STATUS_ID)
      references COMMENT_STATUS (COMMENT_STATUS_ID)
go

alter table ASSOC_STATUS_CUSTOMER
   add constraint FK_ASSOC_STATUS_CUSTOMER_ASSOC_STATUS_CUSTOMER_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID)
go

alter table ASSOC_STATUS_CUSTOMER
   add constraint FK_ASSOC_STATUS_CUSTOMER_ASSOC_STATUS_CUSTOMER2_CUSTOMER_STATUS foreign key (CUSTOMER_STATUS_ID)
      references CUSTOMER_STATUS (CUSTOMER_STATUS_ID)
go

alter table ASSOC_STATUS_ORDER
   add constraint FK_ASSOC_STATUS_ORDER_ASSOC_STATUS_ORDER_ORDER foreign key (ORDER_ID)
      references "ORDER" (ORDER_ID)
go

alter table ASSOC_STATUS_ORDER
   add constraint FK_ASSOC_STATUS_ORDER_ASSOC_STATUS_ORDER2_ORDER_STATUS foreign key (ORDER_STATUS_ID)
      references ORDER_STATUS (ORDER_STATUS_ID)
go

alter table ASSOC_STATUS_PACKAGE
   add constraint FK_ASSOC_STATUS_PACKAGE_ASSOC_STATUS_PACKAGE_PACKAGE_STATUS foreign key (PACKAGE_STATUS_ID)
      references PACKAGE_STATUS (PACKAGE_STATUS_ID)
go

alter table ASSOC_STATUS_PACKAGE
   add constraint FK_ASSOC_STATUS_PACKAGE_ASSOC_STATUS_PACKAGE2_PACKAGE foreign key (PACKAGE_ID)
      references PACKAGE (PACKAGE_ID)
go

alter table ASSOC_STATUS_PAYMENT
   add constraint FK_ASSOC_STATUS_PAYMENT_ASSOC_STATUS_PAYMENT_PAYMENT foreign key (PAYMENT_ID, PAYMENT_SUB_ID)
      references PAYMENT (PAYMENT_ID, PAYMENT_SUB_ID)
go

alter table ASSOC_STATUS_PAYMENT
   add constraint FK_ASSOC_STATUS_PAYMENT_ASSOC_STATUS_PAYMENT2_PAYMENT_STATUS foreign key (PAYMENT_STATUS_ID)
      references PAYMENT_STATUS (PAYMENT_STATUS_ID)
go

alter table BOOK
   add constraint FK_BOOK_ASSOC_BOOK_PUBLISHER_PUBLISHER foreign key (PUBLISHER_ID)
      references PUBLISHER (PUBLISHER_ID)
go

alter table BOOK
   add constraint FK_BOOK_ASSOC_VAT_BOOK_VAT foreign key (VAT_ID)
      references VAT (VAT_ID)
go

alter table CARD_TYPE
   add constraint FK_CARD_TYPE_ASSOC_CARD_TYPE_PAYMENT__PAYMENT_ORGANIZATION foreign key (PAYMENT_ORGANIZATION_ID)
      references PAYMENT_ORGANIZATION (PAYMENT_ORGANIZATION_ID)
go

alter table CARRIER
   add constraint FK_CARRIER_ASSOC_ADDRESS_CARRIER_ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table COMMENT
   add constraint FK_COMMENT_ASSOC_BOOK_COMMENT_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table COMMENT
   add constraint FK_COMMENT_ASSOC_COMMAND_ROW_COMMEN_ORDER_ROW foreign key (ORDER_ROW_ID)
      references ORDER_ROW (ORDER_ROW_ID)
go

alter table COMMENT
   add constraint FK_COMMENT_ASSOC_COMMENT_CUSTOMER_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID)
go

alter table "ORDER"
   add constraint FK_ORDER_ASSOC_ORDER_BILLING_ADDR_ADDRESS foreign key (BILLING_ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table "ORDER"
   add constraint FK_ORDER_ASSOC_ORDER_CUSTOMER_CUSTOMER foreign key (CUSTOMER_ID)
      references CUSTOMER (CUSTOMER_ID)
go

alter table "ORDER"
   add constraint FK_ORDER_ASSOC_ORDER_DELIVERY_ADD_ADDRESS foreign key (DELIVERY_ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table "ORDER"
   add constraint FK_ORDER_ASSOC_SHIPPING_OFFER_ORD_SHIPPING_OFFER foreign key (SHIPPING_OFFER_ID)
      references SHIPPING_OFFER (SHIPPING_OFFER_ID)
go

alter table ORDER_ROW
   add constraint FK_ORDER_ROW_ASSOC_BOOK_ORDER_ROW_BOOK foreign key (BOOK_ISBN)
      references BOOK (BOOK_ISBN)
go

alter table ORDER_ROW
   add constraint FK_ORDER_ROW_ASSOC_COMMAND_ROW_COMMEN_COMMENT foreign key (COMMENT_ID)
      references COMMENT (COMMENT_ID)
go

alter table ORDER_ROW
   add constraint FK_ORDER_ROW_ASSOC_ORDER_ROW_ORDER_ORDER foreign key (ORDER_ID)
      references "ORDER" (ORDER_ID)
go

alter table PAYMENT
   add constraint FK_PAYMENT_ASSOC_PAYMENT_CARD_TYPE_CARD_TYPE foreign key (CARD_TYPE_ID)
      references CARD_TYPE (CARD_TYPE_ID)
go

alter table PAYMENT
   add constraint FK_PAYMENT_ASSOC_PAYMENT_ORDER_ORDER foreign key (ORDER_ID)
      references "ORDER" (ORDER_ID)
go

alter table PAYMENT_ORGANIZATION
   add constraint FK_PAYMENT_ORGANIZATION_ASSOC_ADDRESS_PAYEMENT_O_ADDRESS foreign key (ADDRESS_ID)
      references ADDRESS (ADDRESS_ID)
go

alter table SHIPPING_OFFER
   add constraint FK_SHIPPING_OFFER_ASSOC_CARRIER_SHIPPING_O_CARRIER foreign key (CARRIER_ID)
      references CARRIER (CARRIER_ID)
go

