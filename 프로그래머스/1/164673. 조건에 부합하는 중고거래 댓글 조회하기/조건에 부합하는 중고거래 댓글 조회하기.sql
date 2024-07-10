select b.TITLE, b.BOARD_ID, r.REPLY_ID, r.WRITER_ID, r.CONTENTS, date_format(r.created_date,'%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD as b
join USED_GOODS_REPLY as r on b.board_id = r.board_id
where b.created_date like '2022-10-%'
order by CREATED_DATE, b.title asc;

