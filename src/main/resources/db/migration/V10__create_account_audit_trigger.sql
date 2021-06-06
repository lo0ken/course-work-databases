alter table account add column updated_at timestamp;

create or replace function update_account_audit() returns trigger as
$$BEGIN
    NEW.updated_at := current_timestamp;
    return NEW;
END$$ language plpgsql;

create trigger account_audit BEFORE INSERT OR UPDATE on account
for each row execute procedure update_account_audit();