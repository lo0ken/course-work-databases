create or replace function getTransactionFiltered(startDate date, endDate date, userId int)
    returns setof transaction language plpgsql

as $$ begin
    return query select t.* from transaction t
                                     join account acc on t.account_id = acc.id
                                     left join transaction_tag tt on t.id = tt.transaction_id
                                     left join tag on tt.tag_id = tag.id
                 where acc.user_id = userId
                   and t.date >= startDate
                   and t.date <= endDate;
end; $$;