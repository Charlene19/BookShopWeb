package res;

/**
 *
 * @author zvr
 */
public class Values {

    public final static String PARAM_USERNAME = "username";
    public final static String PARAM_PASSWORD = "password";
    public final static String PARAM_CUSTOMER = "customer";
    public final static String PARAM_ACTION = "action";
    public final static String PARAM_ORIGIN = "origin";
    public final static String PARAM_BOOKS = "books";
    public final static String PARAM_BOOK = "book";
    public final static String PARAM_ISBN = "isbn";
    public final static String PARAM_COMMENTS = "comments";
    public final static String PARAM_ERROR_MSG = "error_msg";
    public final static String PARAM_MSG = "message";
    public final static String PARAM_LAST_SEEN_BOOKS = "last_seen_books";
    public final static String PARAM_BEST_SALES_BOOKS = "best_sales_books";
    
    public final static String ACTION_LOGIN = "login";
    public final static String ACTION_LOGOUT = "logout";
    public final static String ACTION_REGISTER = "register";
    public final static String ACTION_CREATE_ORDER = "create_order";
    public final static String ACTION_VALIDATED_ORDER = "validated_order";
    public final static String ACTION_ADD_BOOK = "add_book";
    public final static String ACTION_DEL_BOOK = "rem_book";
    public final static String ACTION_INC_BOOK = "inc_book";
    public final static String ACTION_DEC_BOOK = "dec_book";
    public final static String ACTION_EMPTY_CART = "empty_cart";
    public final static String ACTION_GOTO_CART = "cart";
    public final static String ACTION_YES = "oui";
    public final static String ACTION_NO = "non";
    
    public final static String ERROR_INVALID_LOGIN = "Identifiants invalides";
    public final static String ERROR_NO_BOOK = "Aucun livre à afficher";
    public final static String ERROR_EMPTY_CART = "Le panier est vide";
    
    public final static String MSG_LOGIN_SUCCESS = "Identifiants OK";
    public final static String MSG_BOOK_QTY_CHANGED = "La quantité du livre %s est passée a %d";
    public final static String MSG_BOOK_REMOVED = "Le livre %s a été retiré du panier";
    public final static String MSG_BOOK_ADDED = "Le livre %s a été ajouté au panier";
    public final static String MSG_CART_CLEARED = "Le panier a été vidé";
    public final static String MSG_LOGIN_TO_ORDER = "Connectez-vous pour passer commande";
    
    public final static String BEAN_LOGIN_NAME = "bean_login";
    public final static String BEAN_SHOPPING_CART_NAME = "bean_shopping_cart";
    public final static String BEAN_ORDER_VALIDATION_NAME = "bean_order_val";
    
    public final static String JSP_HOME = "/WEB-INF/homePageJsp.jsp";
    public final static String JSP_ERROR = "/WEB-INF/error_full.jsp";
    public final static String JSP_INFO = "/WEB-INF/info_full.jsp";
    public final static String JSP_SHOPPING_CART = "/WEB-INF/shopping_cart.jsp";
    public final static String JSP_SHOPPING_CART_FULL = "/WEB-INF/shopping_cart_full.jsp";
    public final static String JSP_LOGIN = "/WEB-INF/login.jsp";
    public final static String JSP_LOGIN_FULL = "/WEB-INF/login_full.jsp";
    public final static String JSP_REGISTER_FULL = "/WEB-INF/register_full.jsp";
    public final static String JSP_ACCOUNT = "myAccount.jsp";
    public final static String JSP_REGISTER = "register.jsp";
    public final static String JSP_BOOK_INFO = "/WEB-INF/book_info.jsp";
    public final static String JSP_BOOK_INFO_FULL = "/WEB-INF/book_info_full.jsp";
    public final static String JSP_ORDER_VALIDATION_FULL = "/WEB-INF/order_validation_full.jsp";
    
    public final static String SERVLET_HOME = "/HomePage";
    
    // Order 
    
    public final static String ORDER_LASTMONTH = "listMonth"; 
    public final static String ORDER_SIXMONTH = "listSixMonth";
    public final static String ORDER_PAST = "listPast"; 
    
    public final static String JSP_NOTLOG = "WEB-INF/notLog.jsp";
    public final static String ERROR_NOT_LOGIN = "Non identifié";
    public final static String ERROR_NO_ORDER = "Aucune commande à afficher";
    

    // Search: 
    
    public final static String QUICK_SEARCH_CONTROLLER = "Resultats";
    public final static String JSP_BOOK = "/WEB-INF/book_info.jsp";

 
  }