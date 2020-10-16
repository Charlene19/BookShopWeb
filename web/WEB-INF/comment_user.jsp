<!-- customer comment container -->
<div id="k_box_book_comment">

    <!-- method should be POST -->
    <form action="/book.html" method="get">

        <div id="k_box_book_comment_title">
            Titre du commentaire :
            <input class="k_text_field" type="text" name="comment_title" />
        </div>

        <div id="k_box_book_comment_msg">
            Message :
            <textarea class="k_text_field" name="comment_msg" cols="50" rows="4"></textarea>
        </div>

        <div id="k_box_book_comment_details">
            Note :
            <input class="k_input_number_select" type="number" name="comment_rating" min="0" max="5" /> / 5
            <div class="k_right">
                <button class="bttn-unite" type="submit" name="action" value="send_comment">Envoyer le commentaire</button>
            </div>

        </div>
    </form>
</div>
