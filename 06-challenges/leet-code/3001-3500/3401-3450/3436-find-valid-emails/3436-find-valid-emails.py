# https://leetcode.com/problems/find-valid-emails/
import pandas as pd

def find_valid_emails(users: pd.DataFrame) -> pd.DataFrame:
    pattern = r'^[A-Za-z0-9_]+@[A-Za-z]+\.com$'
    valid = users[users['email'].str.match(pattern)]
    return valid[['user_id', 'email']].sort_values('user_id').reset_index(drop=True)
