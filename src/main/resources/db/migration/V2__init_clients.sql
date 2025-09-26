-- Demo client using Client Credentials flow
INSERT INTO oauth2_registered_client (
    id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    scopes,
    client_settings,
    token_settings
) VALUES (
    gen_random_uuid(),
    'demo-client',
    CURRENT_TIMESTAMP,
    '{noop}demo-secret',
    'Demo Client',
    'client_secret_basic',
    'client_credentials,refresh_token',
    NULL,
    'read,write',
    '{"requireProofKey":false,"requireAuthorizationConsent":false}',
    '{"accessTokenTimeToLive":"PT1H","reuseRefreshTokens":true,"refreshTokenTimeToLive":"P30D"}'
) ON CONFLICT (client_id) DO NOTHING;


-- Web app client using Authorization Code + PKCE
INSERT INTO oauth2_registered_client (
    id,
    client_id,
    client_id_issued_at,
    client_secret,
    client_name,
    client_authentication_methods,
    authorization_grant_types,
    redirect_uris,
    scopes,
    client_settings,
    token_settings
) VALUES (
    gen_random_uuid(),
    'web-client',
    CURRENT_TIMESTAMP,
    '{noop}web-secret',
    'Web Application Client',
    'client_secret_basic',
    'authorization_code,refresh_token',
    'http://127.0.0.1:8080/login/oauth2/code/web-client-oidc',
    'openid,profile,email',
    '{"requireProofKey":true,"requireAuthorizationConsent":true}',
    '{"accessTokenTimeToLive":"PT15M","reuseRefreshTokens":false,"refreshTokenTimeToLive":"P7D"}'
) ON CONFLICT (client_id) DO NOTHING;
