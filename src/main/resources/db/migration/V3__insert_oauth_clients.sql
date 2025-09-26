-- V3__insert_oauth_clients.sql
-- Inserts demo client(s) into oauth2_registered_client

INSERT INTO oauth2_registered_client (
    id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_secret_expires_at,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    scopes,
    client_settings,
    token_settings
)
VALUES (
    gen_random_uuid(), -- requires pgcrypto extension
    'demo-client',
    NOW(),
    '{noop}demo-secret', -- encoder prefix
    NULL,
    'Demo Client App',
    'client_secret_basic',
    'client_credentials,refresh_token',
    'http://127.0.0.1:8080/login/oauth2/code/demo-client',
    'read,write,openid',
    '{"requireProofKey":false,"requireAuthorizationConsent":true}',
    '{"reuseRefreshTokens":true,"accessTokenTimeToLive":"PT1H","refreshTokenTimeToLive":"P30D"}'
);

-- Optional: Add a second client for testing authorization_code flow
INSERT INTO oauth2_registered_client (
    id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_secret_expires_at,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    scopes,
    client_settings,
    token_settings
)
VALUES (
    gen_random_uuid(),
    'web-client',
    NOW(),
    '{noop}web-secret',
    NULL,
    'Web Client',
    'client_secret_basic',
    'authorization_code,refresh_token',
    'http://127.0.0.1:3000/login/oauth2/code/web-client',
    'read,write,openid,profile,email',
    '{"requireProofKey":true,"requireAuthorizationConsent":true}',
    '{"reuseRefreshTokens":true,"accessTokenTimeToLive":"PT5M","refreshTokenTimeToLive":"P1D"}'
);
