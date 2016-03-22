CREATE TABLE ACCT_Account (
  id            BIGINT       NOT NULL AUTO_INCREMENT,
  Balance_NR    BIGINT       NOT NULL,
  CreateTime_DT DATETIME     NOT NULL,
  Name_TX       VARCHAR(100) NOT NULL,
  State_NR      INTEGER      NOT NULL,
  StateInfo_TX  VARCHAR(100),
  UpdateTime_DT DATETIME     NOT NULL,
  Owner_ID      BIGINT       NOT NULL,
  Type_ID       BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ACCT_AccountLog (
  id            BIGINT   NOT NULL AUTO_INCREMENT,
  Balance_NR    BIGINT   NOT NULL,
  CreateTime_DT DATETIME NOT NULL,
  Money_NR      BIGINT   NOT NULL,
  Note_TX       VARCHAR(100),
  RelatedId_NR  BIGINT,
  Subtype_NR    INTEGER  NOT NULL,
  Type_NR       INTEGER  NOT NULL,
  Account_ID    BIGINT   NOT NULL,
  Owner_ID      BIGINT   NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE ACCT_AccountType (
  id            BIGINT       NOT NULL AUTO_INCREMENT,
  AutoCreate_YN BIT          NOT NULL,
  Direction_NR  INTEGER      NOT NULL,
  Name_TX       VARCHAR(100) NOT NULL,
  Note_TX       VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AccountLog (
  id                          BIGINT NOT NULL AUTO_INCREMENT,
  domainId                    BIGINT,
  member_id                   BIGINT,
  account_id                  BIGINT,
  order_no                    BIGINT,
  order_split_rule_id         BIGINT,
  app_order_no                VARCHAR(50),
  account_type_id             BIGINT,
  account_type_label          VARCHAR(200),
  account_type_no             VARCHAR(50),
  opposite_member_id          BIGINT,
  opposite_member_name        VARCHAR(100),
  opposite_account_id         BIGINT,
  opposite_account_type_id    BIGINT,
  opposite_account_type_label VARCHAR(200),
  trade_type                  BIGINT,
  sub_trade_type              BIGINT,
  trade_time                  DATETIME,
  cur_amount                  BIGINT,
  ori_amount                  BIGINT,
  chg_amount                  BIGINT,
  remark                      VARCHAR(100),
  trade_id                    BIGINT,
  pay_mode_name               VARCHAR(100),
  pay_channel_no              VARCHAR(50),
  pay_interface_no            VARCHAR(50),
  bank_code                   VARCHAR(30),
  command_id                  BIGINT,
  log_type                    VARCHAR(10),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AccountRiskData (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  domainId       BIGINT,
  member_id      BIGINT,
  account_type   VARCHAR(20),
  trade_type     BIGINT,
  sub_trade_type BIGINT,
  pay_channel    VARCHAR(20),
  belong_time    DATETIME,
  day_total      BIGINT,
  day_num        BIGINT,
  month_total    BIGINT,
  app_id         BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AccountStatusLog (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  domainId             BIGINT,
  member_id            BIGINT,
  account_id           BIGINT,
  order_no             VARCHAR(50),
  app_order_no         VARCHAR(50),
  account_type_id      BIGINT,
  account_type_label   VARCHAR(200),
  chg_time             DATETIME,
  ori_freeze_amount    BIGINT,
  cur_freeze_amount    BIGINT,
  chg_freeze_amount    BIGINT,
  ori_overdraft_amount BIGINT,
  cur_overdraft_amount BIGINT,
  chg_overdraft_amount BIGINT,
  ori_valid_date       DATETIME,
  cur_valid_date       DATETIME,
  remark               VARCHAR(300),
  command_id           BIGINT,
  log_type             BIGINT,
  ori_status           BIGINT,
  cur_status           BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AccountType (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  domainId       BIGINT,
  code_no        VARCHAR(50),
  valid_type     BIGINT,
  valid_merge    BIGINT,
  name           VARCHAR(100),
  biz_def        VARCHAR(1024),
  extend_day     BIGINT,
  description    VARCHAR(300),
  currency_id    BIGINT,
  currency_label VARCHAR(200),
  currency_no    VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Address (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  member_id    BIGINT,
  principal_id BIGINT,
  province     VARCHAR(100),
  city         VARCHAR(100),
  county       VARCHAR(100),
  address      VARCHAR(100),
  postcode     VARCHAR(100),
  name         VARCHAR(100),
  phone        VARCHAR(100),
  cust_area    VARCHAR(100),
  is_defult    BIT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AdjustAccount (
  id                        BIGINT NOT NULL AUTO_INCREMENT,
  WF_State                  INTEGER,
  WF_StateName              VARCHAR(50),
  WF_ProcessId              BIGINT,
  WF_ProcessName            VARCHAR(100),
  FM_CreatePrinId           BIGINT,
  FM_CreatePrinName         VARCHAR(100),
  FM_UpdatePrinId           BIGINT,
  FM_UpdatePrinName         VARCHAR(100),
  FM_CreateTime             DATETIME,
  FM_UpdateTime             DATETIME,
  WF_ProcessorPrinId        BIGINT,
  WF_ProcessorPrinName      VARCHAR(100),
  WF_WorkItemId             BIGINT,
  domainId                  BIGINT,
  s_member_id               BIGINT,
  s_member_label            VARCHAR(200),
  t_member_id               BIGINT,
  t_member_label            VARCHAR(200),
  remark                    VARCHAR(1024),
  account_type_id           BIGINT,
  account_type_label        VARCHAR(200),
  trade_money               BIGINT,
  error_trade_handler_id    BIGINT,
  error_trade_handler_label VARCHAR(200),
  auditor_id                BIGINT,
  auditor_name              VARCHAR(100),
  auditor_date              DATETIME,
  operator_id               BIGINT,
  operator_label            VARCHAR(200),
  bizid                     VARCHAR(255),
  error_msg                 VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AppCertificate (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  domainId    BIGINT,
  app_id      BIGINT,
  cert_name   VARCHAR(100),
  public_key  VARCHAR(8000),
  private_key VARCHAR(8000),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AppPayAuth (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  domainId            BIGINT,
  account_type_id     BIGINT,
  account_type_label  VARCHAR(200),
  pay_interface_id    BIGINT,
  pay_interface_label VARCHAR(200),
  pay_interface_no    VARCHAR(100),
  application_id      BIGINT,
  application_label   VARCHAR(200),
  app_id              BIGINT,
  is_debit            BIT,
  is_credit           BIT,
  pay_interface_type  BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_AppTradeAuth (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  domainId          BIGINT,
  application_id    BIGINT,
  application_label VARCHAR(200),
  trade_type        BIGINT,
  sub_trade_type    BIGINT,
  app_id            BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Application (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  name         VARCHAR(100),
  developer_id BIGINT,
  remark       VARCHAR(500),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Bank (
  id            BIGINT NOT NULL AUTO_INCREMENT,
  domainId      BIGINT,
  name          VARCHAR(100),
  bank_code     VARCHAR(100),
  short_name    VARCHAR(100),
  its_bank_code VARCHAR(100),
  logo          VARCHAR(200),
  en_bank_code  VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_BankCode (
  id         BIGINT NOT NULL AUTO_INCREMENT,
  domainId   BIGINT,
  bank_code  VARCHAR(100),
  cart_type  BIGINT,
  bank_id    BIGINT,
  bank_label VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_BillingFee (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  domainId            BIGINT,
  billing_mode        BIGINT,
  max_fee             BIGINT,
  fee_fixed           BIGINT,
  fee_rate            DOUBLE PRECISION,
  min_fee             BIGINT,
  billing_type        BIGINT,
  trade_type          BIGINT,
  sub_trade_type      BIGINT,
  app_id              BIGINT,
  account_type_id     BIGINT,
  account_type_label  VARCHAR(200),
  pay_interface_no    VARCHAR(100),
  application_id      BIGINT,
  application_label   VARCHAR(200),
  pay_interface_id    BIGINT,
  pay_interface_label VARCHAR(200),
  pay_interface_type  BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_BillingLog (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  member_uid   VARCHAR(100),
  member_name  VARCHAR(100),
  trade_time   DATETIME,
  trade_money  BIGINT,
  billing_fee  BIGINT,
  trade_no     VARCHAR(50),
  order_no     VARCHAR(50),
  billing_mode BIGINT,
  is_charged   BIT,
  app_id       BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_BillingParam (
  id              BIGINT NOT NULL AUTO_INCREMENT,
  domainId        BIGINT,
  member_type     BIGINT,
  real_name_state BIGINT,
  member_level    BIGINT,
  pay_tool        BIGINT,
  target          BIGINT,
  billing_mode    BIGINT,
  max_fee         BIGINT,
  fee_fixed       BIGINT,
  fee_rate        DOUBLE PRECISION,
  min_fee         BIGINT,
  billing_type    BIGINT,
  trade_type      BIGINT,
  sub_trade_type  BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_BillingReverseEntry (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  WF_State             INTEGER,
  WF_StateName         VARCHAR(50),
  WF_ProcessId         BIGINT,
  WF_ProcessName       VARCHAR(100),
  FM_CreatePrinId      BIGINT,
  FM_CreatePrinName    VARCHAR(100),
  FM_UpdatePrinId      BIGINT,
  FM_UpdatePrinName    VARCHAR(100),
  FM_CreateTime        DATETIME,
  FM_UpdateTime        DATETIME,
  WF_ProcessorPrinId   BIGINT,
  WF_ProcessorPrinName VARCHAR(100),
  WF_WorkItemId        BIGINT,
  domainId             BIGINT,
  prev_balance         BIGINT,
  operator_id          BIGINT,
  operator_label       VARCHAR(200),
  operate_date         DATETIME,
  auditor_id           BIGINT,
  auditor_label        VARCHAR(200),
  audit_date           DATETIME,
  balance              BIGINT,
  trade_money          BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_CaptchaCode (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  domainId          BIGINT,
  captcha_code      VARCHAR(100),
  captcha_code_type BIGINT,
  create_time       DATETIME,
  invalid_time      DATETIME,
  member_id         BIGINT,
  is_validated      BIT,
  validate_time     DATETIME,
  email             VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_CardBin (
  id              BIGINT NOT NULL AUTO_INCREMENT,
  domainId        BIGINT,
  card_bin        VARCHAR(100),
  card_type       BIGINT,
  bank_code       VARCHAR(100),
  bank_name       VARCHAR(100),
  card_name       VARCHAR(100),
  card_length     BIGINT,
  card_state      BIGINT,
  card_type_label VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_CheckBalance (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  balance_date      DATETIME,
  balance           BIGINT,
  deposit_amount    BIGINT,
  withdraw_aount    BIGINT,
  currency_id       BIGINT,
  currency_label    VARCHAR(200),
  prev_balance      BIGINT,
  balance_type      BIGINT,
  adjust_amount     BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_CheckTrade (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  check_date        DATETIME,
  check_result      BIGINT,
  channel_file      VARCHAR(1000),
  account_file      VARCHAR(1000),
  check_result_file VARCHAR(1000),
  remark            VARCHAR(1024),
  pay_channel_no    VARCHAR(255),
  download_state    BIGINT,
  check_state       BIGINT,
  download_time     DATETIME,
  check_time        DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Command (
  id              BIGINT NOT NULL AUTO_INCREMENT,
  domainId        BIGINT,
  order_no        BIGINT,
  type_code       VARCHAR(50),
  trade_type      BIGINT,
  sub_trade_type  BIGINT,
  params          VARCHAR(4000),
  sign            VARCHAR(100),
  create_time     DATETIME,
  execute_time    DATETIME,
  execute_result  VARCHAR(800),
  execute_state   BIGINT,
  execute_context VARCHAR(100),
  next_command_id BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Currency (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  domainId       BIGINT,
  code_no        VARCHAR(20),
  name           VARCHAR(100),
  unit           VARCHAR(20),
  symbol         VARCHAR(10),
  unit_precision BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Developer (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  name         VARCHAR(100),
  mobile       VARCHAR(100),
  email        VARCHAR(100),
  principal_id BIGINT,
  login_id     VARCHAR(100),
  password     VARCHAR(300),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_EmailTemplate (
  id                     BIGINT NOT NULL AUTO_INCREMENT,
  domainId               BIGINT,
  verification_code_type BIGINT,
  contents               VARCHAR(8000),
  template_no            VARCHAR(100),
  email_url              VARCHAR(300),
  theme                  VARCHAR(1000),
  application_id         BIGINT,
  application_label      VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_ErrorTradeHandle (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  WF_State             INTEGER,
  WF_StateName         VARCHAR(50),
  WF_ProcessId         BIGINT,
  WF_ProcessName       VARCHAR(100),
  FM_CreatePrinId      BIGINT,
  FM_CreatePrinName    VARCHAR(100),
  FM_UpdatePrinId      BIGINT,
  FM_UpdatePrinName    VARCHAR(100),
  FM_CreateTime        DATETIME,
  FM_UpdateTime        DATETIME,
  WF_ProcessorPrinId   BIGINT,
  WF_ProcessorPrinName VARCHAR(100),
  WF_WorkItemId        BIGINT,
  domainId             BIGINT,
  order_no             BIGINT,
  pay_channel_no       VARCHAR(100),
  pay_channel_name     VARCHAR(100),
  out_trade_money      BIGINT,
  pay_interface_no     VARCHAR(100),
  pay_interface_name   VARCHAR(100),
  remark               VARCHAR(1024),
  trade_time           VARCHAR(100),
  card_no              VARCHAR(100),
  code_no              VARCHAR(100),
  out_trade_id         VARCHAR(100),
  error_type           BIGINT,
  error_message        VARCHAR(100),
  treatment_result     BIGINT,
  operator_id          BIGINT,
  operator_label       VARCHAR(200),
  auditor_id           BIGINT,
  auditor_label        VARCHAR(200),
  audit_date           DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_ErrorTradeLog (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  order_no           BIGINT,
  out_trade_id       VARCHAR(100),
  trade_money        BIGINT,
  out_trade_money    BIGINT,
  member_id          BIGINT,
  pay_channel_no     VARCHAR(100),
  pay_channel_name   VARCHAR(100),
  trade_time         VARCHAR(100),
  error_type         BIGINT,
  remark             VARCHAR(512),
  card_no            VARCHAR(100),
  mobile_no          VARCHAR(100),
  name               VARCHAR(100),
  is_handled         BIT,
  trade_type         BIGINT,
  out_trade_type     VARCHAR(100),
  sub_trade_type     BIGINT,
  pay_interface_no   VARCHAR(100),
  pay_interface_name VARCHAR(100),
  create_time        DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Forum (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  message      VARCHAR(2048),
  type         BIGINT,
  thread_id    BIGINT,
  reply_id     BIGINT,
  contact      VARCHAR(100),
  member_id    BIGINT,
  member_label VARCHAR(200),
  create_time  DATETIME,
  os_type      BIGINT,
  os_version   VARCHAR(100),
  mobile_brand VARCHAR(100),
  mobile_model VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_FreezeAdjust (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId    BIGINT,
  FM_CreatePrinName  VARCHAR(100),
  FM_UpdatePrinId    BIGINT,
  FM_UpdatePrinName  VARCHAR(100),
  FM_CreateTime      DATETIME,
  FM_UpdateTime      DATETIME,
  domainId           BIGINT,
  member_id          BIGINT,
  account_type_id    BIGINT,
  account_type_label VARCHAR(200),
  freeze_type        BIGINT,
  trade_id           BIGINT,
  freeze_bizid       VARCHAR(50),
  request_id         VARCHAR(50),
  amount             BIGINT,
  remark             VARCHAR(1024),
  app_id             BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_FreezeLog (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  freeze_date        DATETIME,
  freeze_amount      BIGINT,
  account_type_id    BIGINT,
  account_type_label VARCHAR(200),
  account_id         BIGINT,
  freeze_state       BIGINT,
  bizid              VARCHAR(100),
  member_id          BIGINT,
  balance            BIGINT,
  request_id         VARCHAR(50),
  app_id             BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_FreezeLogDetail (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  freeze_log_id      BIGINT,
  account_id         BIGINT,
  account_type_id    BIGINT,
  account_type_label VARCHAR(200),
  member_id          BIGINT,
  freeze_date        DATETIME,
  freeze_type        BIGINT,
  trade_id           BIGINT,
  freeze_bizid       VARCHAR(100),
  request_id         VARCHAR(100),
  amount             BIGINT,
  remark             VARCHAR(1024),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_ManualWithdraw (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  WF_State             INTEGER,
  WF_StateName         VARCHAR(50),
  WF_ProcessId         BIGINT,
  WF_ProcessName       VARCHAR(100),
  FM_CreatePrinId      BIGINT,
  FM_CreatePrinName    VARCHAR(100),
  FM_UpdatePrinId      BIGINT,
  FM_UpdatePrinName    VARCHAR(100),
  FM_CreateTime        DATETIME,
  FM_UpdateTime        DATETIME,
  WF_ProcessorPrinId   BIGINT,
  WF_ProcessorPrinName VARCHAR(100),
  WF_WorkItemId        BIGINT,
  domainId             BIGINT,
  member_id            BIGINT,
  member_label         VARCHAR(200),
  total_money          BIGINT,
  bank_name            VARCHAR(100),
  bank_branch_no       VARCHAR(100),
  bank_account_no      VARCHAR(100),
  bank_account_name    VARCHAR(100),
  identity_cardNo      VARCHAR(100),
  mobile               VARCHAR(100),
  operator_id          BIGINT,
  operator_label       VARCHAR(200),
  operator_date        DATETIME,
  auditor_id           BIGINT,
  auditor_name         VARCHAR(100),
  auditor_date         DATETIME,
  remark               VARCHAR(1000),
  system_member_id     BIGINT,
  system_member_label  VARCHAR(200),
  code                 VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_ManualWithdrawDetail (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  log_id             BIGINT,
  log_label          VARCHAR(200),
  account_type_id    BIGINT,
  account_type_label VARCHAR(200),
  trade_money        BIGINT,
  account_id         BIGINT,
  account_label      VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Member (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  domainId          BIGINT,
  app_member_id     VARCHAR(50),
  name              VARCHAR(100),
  nickname          VARCHAR(100),
  register_time     DATETIME,
  mobile            VARCHAR(100),
  sex               VARCHAR(2),
  address           VARCHAR(300),
  member_state      BIGINT,
  member_type       BIGINT,
  login_password    VARCHAR(256),
  pay_password      VARCHAR(256),
  email             VARCHAR(100),
  country           VARCHAR(100),
  province          VARCHAR(100),
  city              VARCHAR(100),
  last_login_time   DATETIME,
  is_mobile_checked BIT,
  is_email_checked  BIT,
  has_security_qa   BIT,
  principal_id      BIGINT,
  register_ip       VARCHAR(100),
  remark            VARCHAR(1000),
  app_id            BIGINT,
  has_login_SMS     BIT,
  risk_level        BIGINT,
  master_member_id  BIGINT,
  is_master         BIT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_MemberAccount (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  member_id          BIGINT,
  account_type_id    BIGINT,
  account_type_label VARCHAR(200),
  account_type_no    VARCHAR(50),
  name               VARCHAR(100),
  valid_date         DATETIME,
  balance            BIGINT,
  freeze             BIGINT,
  overdraft          BIGINT,
  status             BIGINT,
  is_system          BIT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_MemberBank (
  id                      BIGINT NOT NULL AUTO_INCREMENT,
  domainId                BIGINT,
  bank_account_prop       BIGINT,
  bank_account_no_encrypt VARCHAR(200),
  bank_account_name       VARCHAR(100),
  account_type_id         BIGINT,
  account_type_label      VARCHAR(200),
  bank_account_no         VARCHAR(100),
  bank_code               VARCHAR(100),
  bank_name               VARCHAR(100),
  bind_time               DATETIME,
  unbind_time             DATETIME,
  member_id               BIGINT,
  member_label            VARCHAR(200),
  card_type               BIGINT,
  id_card_no              VARCHAR(100),
  id_card_no_encrypt      VARCHAR(100),
  bind_state              BIGINT,
  acct_validdate          VARCHAR(20),
  cvv2                    VARCHAR(100),
  mobile                  VARCHAR(50),
  contract_no             VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_MemberInfoExts (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  member_id    BIGINT,
  member_label VARCHAR(200),
  prop_name    VARCHAR(100),
  value_type   BIGINT,
  prop_value   VARCHAR(2000),
  PRIMARY KEY (id)
);
CREATE TABLE AMS_MemberOutAccount (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  member_id          BIGINT,
  member_label       VARCHAR(200),
  account_type_id    BIGINT,
  account_type_label VARCHAR(200),
  out_account_id     VARCHAR(100),
  open_time          DATETIME,
  open_state         BIGINT,
  open_state_label   VARCHAR(50),
  phone              VARCHAR(100),
  sync_message       VARCHAR(512),
  sync_time          DATETIME,
  sync_state         BIGINT,
  balance            VARCHAR(50),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_OperationLog (
  id            BIGINT NOT NULL AUTO_INCREMENT,
  domainId      BIGINT,
  op_date       DATETIME,
  op_type       BIGINT,
  op_user_id    BIGINT,
  op_user_label VARCHAR(200),
  app_id        BIGINT,
  member_id     BIGINT,
  member_label  VARCHAR(200),
  summary       VARCHAR(2000),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Order (
  id                     BIGINT NOT NULL AUTO_INCREMENT,
  domainId               BIGINT,
  create_time            DATETIME,
  owner_member_id        BIGINT,
  owner_member_name      VARCHAR(100),
  opposite_member_id     BIGINT,
  opposite_member_name   VARCHAR(100),
  order_amount           BIGINT,
  unpaid_amount          BIGINT,
  refund_amount          BIGINT,
  pay_status             BIGINT,
  pay_status_name        VARCHAR(50),
  in_sale_status         BIGINT,
  in_sale_status_name    VARCHAR(50),
  after_sale_status      BIGINT,
  after_sale_status_name VARCHAR(50),
  source                 BIGINT,
  remark                 VARCHAR(500),
  order_type             BIGINT,
  description            VARCHAR(1024),
  pay_time               DATETIME,
  delivery_time          DATETIME,
  complete_time          DATETIME,
  trade_type             BIGINT,
  sub_trade_type         BIGINT,
  app_id                 BIGINT,
  extend_info            VARCHAR(1024),
  order_name             VARCHAR(100),
  order_desc             VARCHAR(300),
  order_image_url        VARCHAR(500),
  transaction_type       BIGINT,
  is_artificial          BIT,
  expire                 DATETIME,
  order_url              VARCHAR(128),
  split_rule_id          BIGINT,
  app_order_no           VARCHAR(50),
  industry_code          VARCHAR(50),
  industry_name          VARCHAR(100),
  front_url              VARCHAR(500),
  back_url               VARCHAR(500),
  summary                VARCHAR(500),
  billing_fee            BIGINT,
  terminal_type          VARCHAR(20),
  terminal_info          VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_OrderPayDetail (
  id                        BIGINT NOT NULL AUTO_INCREMENT,
  domainId                  BIGINT,
  pay_state                 BIGINT,
  account_type_id           BIGINT,
  account_type_label        VARCHAR(200),
  order_id                  BIGINT,
  pay_amount                BIGINT,
  pay_channel_no            VARCHAR(50),
  remark                    VARCHAR(100),
  bank_card_no              VARCHAR(100),
  bank_code                 VARCHAR(100),
  bank_card_name            VARCHAR(100),
  bank_card_no_encrypt      VARCHAR(100),
  bank_card_validdate       VARCHAR(100),
  cvv2                      VARCHAR(100),
  pay_interface_no          VARCHAR(50),
  extend_info               VARCHAR(1024),
  bank_card_password        VARCHAR(100),
  bank_card_type            BIGINT,
  bank_card_prop            BIGINT,
  refund_status             BIGINT,
  mobile_no                 VARCHAR(100),
  bank_contract_no          VARCHAR(100),
  bank_name                 VARCHAR(100),
  target_account_type_id    BIGINT,
  target_account_type_label VARCHAR(200),
  target_account_id         BIGINT,
  seq_no                    BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_OrderRefund (
  id       BIGINT NOT NULL AUTO_INCREMENT,
  domainId BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_OrderSplitRule (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  domainId    BIGINT,
  order_id    BIGINT,
  split_rule  VARCHAR(8000),
  create_time DATETIME,
  remark      VARCHAR(300),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_OutAccountType (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  domainId          BIGINT,
  code_no           VARCHAR(50),
  name              VARCHAR(100),
  application_id    BIGINT,
  application_label VARCHAR(200),
  developer_id      BIGINT,
  developer_label   VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_PayChannel (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  name              VARCHAR(100),
  code_no           VARCHAR(50),
  merchant_id       VARCHAR(100),
  remark            VARCHAR(512),
  short_name        VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_PayInterface (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  domainId            BIGINT,
  code_no             VARCHAR(100),
  pay_channel_id      BIGINT,
  pay_channel_label   VARCHAR(200),
  name                VARCHAR(100),
  remark              VARCHAR(256),
  system_member_id    BIGINT,
  system_member_label VARCHAR(200),
  short_name          VARCHAR(100),
  billing_mode        BIGINT,
  billing_each        BIGINT,
  billing_rate        DOUBLE PRECISION,
  billing_type        BIGINT,
  channel_type        BIGINT,
  status              BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_PayInterfaceBank (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  domainId            BIGINT,
  pay_interface_id    BIGINT,
  pay_interface_label VARCHAR(200),
  bank_id             BIGINT,
  bank_label          VARCHAR(200),
  remark              VARCHAR(100),
  pay_interface_no    VARCHAR(100),
  bank_code           VARCHAR(100),
  debit               BIT,
  credit              BIT,
  debit_billing_mode  BIGINT,
  credit_billing_mode BIGINT,
  debit_billing_each  BIGINT,
  credit_billing_each BIGINT,
  debit_billing_type  BIGINT,
  credit_billing_type BIGINT,
  debit_billing_rate  DOUBLE PRECISION,
  credit_billing_rate DOUBLE PRECISION,
  debit_limit_single  BIGINT,
  debit_limit_day     BIGINT,
  debit_limit_month   BIGINT,
  debit_remark        VARCHAR(100),
  credit_limit_single VARCHAR(100),
  credit_limit_day    VARCHAR(100),
  credit_limit_month  VARCHAR(100),
  credit_remark       VARCHAR(100),
  en_bank_code        VARCHAR(100),
  exts                VARCHAR(4000),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_PayLog (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  domainId             BIGINT,
  member_id            BIGINT,
  bank_card_no         VARCHAR(50),
  bank_card_no_encrypt VARCHAR(100),
  bank_code            VARCHAR(30),
  account_name         VARCHAR(100),
  identity_no          VARCHAR(50),
  identity_no_encrypt  VARCHAR(100),
  card_type            BIGINT,
  phone                VARCHAR(100),
  sign_state           BIGINT,
  verification_code    VARCHAR(100),
  tl_contract_no       VARCHAR(100),
  bank_contract_no     VARCHAR(100),
  ret_code             VARCHAR(100),
  ret_msg              VARCHAR(512),
  its_trace_num        VARCHAR(100),
  its_trans_date       VARCHAR(100),
  its_trans_time       VARCHAR(100),
  error_code           VARCHAR(100),
  error_msg            VARCHAR(512),
  trace_num            VARCHAR(100),
  acct_validdate       VARCHAR(100),
  cvv2                 VARCHAR(100),
  send_sms             VARCHAR(100),
  ori_trace_num        VARCHAR(100),
  ori_trans_date       VARCHAR(100),
  cnl_id               VARCHAR(100),
  sign_type            BIGINT,
  trans_date           VARCHAR(100),
  trans_time           VARCHAR(100),
  trans_amount         VARCHAR(100),
  bank_name            VARCHAR(100),
  acct_cat             VARCHAR(100),
  account_type_id      BIGINT,
  account_type_label   VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Principal (
  id               BIGINT NOT NULL AUTO_INCREMENT,
  domainId         BIGINT,
  name             VARCHAR(150),
  country          VARCHAR(50),
  province         VARCHAR(80),
  city             VARCHAR(80),
  area             VARCHAR(100),
  address          VARCHAR(200),
  type             BIGINT,
  identity_type    BIGINT,
  identity_no      VARCHAR(100),
  identity_no_3des VARCHAR(200),
  identity_no_md5  VARCHAR(100),
  risk_level       BIGINT,
  remark           VARCHAR(300),
  mobile           VARCHAR(50),
  identity_time    DATETIME,
  identity_mode    BIGINT,
  identity_note    VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_RiskAttention (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  domainId    BIGINT,
  state       BIGINT,
  memo        VARCHAR(100),
  member_uid  VARCHAR(50),
  create_time DATETIME,
  app_id      BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_RiskAttentionLog (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  domainId    BIGINT,
  member_id   BIGINT,
  create_time DATETIME,
  risk_rule   BIGINT,
  memo        VARCHAR(100),
  app_id      BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_RiskBlackList (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  member_id         BIGINT,
  certificate_type  BIGINT,
  certificate_id    VARCHAR(50),
  bank_card_no      VARCHAR(50),
  mobile            VARCHAR(30),
  ip                VARCHAR(50),
  source            VARCHAR(50),
  description       VARCHAR(300),
  app_id            BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_RiskParam (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  risk_code         VARCHAR(100),
  member_type       BIGINT,
  real_name_state   BIGINT,
  account_type      VARCHAR(20),
  trade_type        BIGINT,
  sub_trade_type    BIGINT,
  pay_channel       VARCHAR(20),
  per_limit         BIGINT,
  day_limit         BIGINT,
  day_limit_num     BIGINT,
  month_limit       BIGINT,
  app_id            BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_SMSTemplate (
  id                     BIGINT NOT NULL AUTO_INCREMENT,
  domainId               BIGINT,
  verification_code_type BIGINT,
  contents               VARCHAR(512),
  template_no            VARCHAR(50),
  application_id         BIGINT,
  application_label      VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_SecurityLevel (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  domainId       BIGINT,
  member_id      BIGINT,
  auth_level     BIGINT,
  security_level BIGINT,
  edit_time      DATETIME,
  company        VARCHAR(100),
  email          VARCHAR(100),
  request_time   DATETIME,
  auth_sp        BIGINT,
  trigger_times  BIGINT,
  trigger_date   DATETIME,
  app_id         BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_SecurityLevelLog (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  domainId       BIGINT,
  member_id      BIGINT,
  type           BIGINT,
  old_level      BIGINT,
  new_level      BIGINT,
  memo           VARCHAR(100),
  create_time    DATETIME,
  deal_result    BIGINT,
  operation_type BIGINT,
  app_id         BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_Setting (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  param_name        VARCHAR(100),
  param_value       VARCHAR(100),
  value_type        BIGINT,
  remark            VARCHAR(1024),
  PRIMARY KEY (id)
);

CREATE TABLE AMS_SubAccount (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  domainId             BIGINT,
  valid_date           DATETIME,
  master_account_id    BIGINT,
  master_account_label VARCHAR(200),
  balance              BIGINT,
  freeze               BIGINT,
  member_id            BIGINT,
  member_label         VARCHAR(200),
  biz_id               VARCHAR(100),
  create_time          DATETIME,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_TradeLog (
  id                   BIGINT NOT NULL AUTO_INCREMENT,
  domainId             BIGINT,
  order_no             BIGINT,
  app_order_no         VARCHAR(50),
  currency             VARCHAR(20),
  trade_type           BIGINT,
  sub_trade_type       BIGINT,
  trade_money          BIGINT,
  trade_time           DATETIME,
  s_account_id         BIGINT,
  t_account_id         BIGINT,
  s_account_type_id    BIGINT,
  s_account_type_label VARCHAR(200),
  t_account_type_id    BIGINT,
  t_account_type_label VARCHAR(200),
  rollback_id          BIGINT,
  rollback_source_id   BIGINT,
  channel_req_id       VARCHAR(50),
  channel_req_sn       VARCHAR(50),
  channel_trans_id     VARCHAR(50),
  channel_bizno        VARCHAR(50),
  bank_card_type       BIGINT,
  remark               VARCHAR(200),
  s_member_id          BIGINT,
  s_member_label       VARCHAR(200),
  t_member_id          BIGINT,
  t_member_label       VARCHAR(200),
  pay_channel_no       VARCHAR(30),
  pay_interface_no     VARCHAR(30),
  pay_interface_name   VARCHAR(100),
  bank_code            VARCHAR(30),
  bank_name            VARCHAR(100),
  pay_i_fee            BIGINT,
  pay_i_fee_mode       BIGINT,
  command_id           BIGINT,
  app_id               BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_TradeMonitorLog (
  id           BIGINT NOT NULL AUTO_INCREMENT,
  domainId     BIGINT,
  monitor_type BIGINT,
  memo         VARCHAR(100),
  reason       VARCHAR(100),
  create_time  DATETIME,
  member_id    BIGINT,
  app_id       BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE AMS_TradeRule (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId     BIGINT,
  FM_CreatePrinName   VARCHAR(100),
  FM_UpdatePrinId     BIGINT,
  FM_UpdatePrinName   VARCHAR(100),
  FM_CreateTime       DATETIME,
  FM_UpdateTime       DATETIME,
  domainId            BIGINT,
  trade_type          BIGINT,
  sub_trade_type      BIGINT,
  pay_interface_id    BIGINT,
  pay_interface_label VARCHAR(200),
  pay_interface_no    VARCHAR(100),
  account_type_id     BIGINT,
  account_type_label  VARCHAR(200),
  debit               BIT,
  credit              BIT,
  account_no          VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE BILL_AccountBill (
  id             BIGINT   NOT NULL AUTO_INCREMENT,
  CreateTime_DT  DATETIME NOT NULL,
  EndTime_DT     DATETIME NOT NULL,
  PayTime_DT     DATETIME,
  StartTime_DT   DATETIME NOT NULL,
  State_NR       INTEGER  NOT NULL,
  StateInfo_TX   VARCHAR(100),
  Total_NR       BIGINT   NOT NULL,
  Consumer_ID    BIGINT   NOT NULL,
  Operator_ID    BIGINT   NOT NULL,
  PayOperator_ID BIGINT,
  Supplier_ID    BIGINT   NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE BILL_BillDetail (
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  EndTime_DT   DATETIME     NOT NULL,
  Name_TX      VARCHAR(100) NOT NULL,
  Note_TX      VARCHAR(100),
  Price_NR     BIGINT       NOT NULL,
  StartTime_DT DATETIME     NOT NULL,
  Bill_ID      BIGINT       NOT NULL,
  Service_ID   BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE BILL_BillLog (
  id            BIGINT   NOT NULL AUTO_INCREMENT,
  CreateTime_DT DATETIME NOT NULL,
  Money_NR      BIGINT   NOT NULL,
  Note_TX       VARCHAR(100),
  Type_NR       INTEGER  NOT NULL,
  Bill_ID       BIGINT   NOT NULL,
  Operator_ID   BIGINT   NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE BIZS_BizService (
  st             VARCHAR(31)  NOT NULL,
  id             BIGINT       NOT NULL AUTO_INCREMENT,
  CreateTime_DT  DATETIME     NOT NULL,
  Name_TX        VARCHAR(100) NOT NULL,
  Note_TX        VARCHAR(100),
  PeriodDays_NR  INTEGER,
  PeriodType_NR  INTEGER,
  Price_NR       BIGINT       NOT NULL,
  ServiceType_NR INTEGER      NOT NULL,
  State_NR       INTEGER      NOT NULL,
  State_TX       VARCHAR(100),
  UpdateTime_DT  DATETIME     NOT NULL,
  Group_ID       BIGINT       NOT NULL,
  Supplier_ID    BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE BIZS_ServiceItem (
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  EDefault_NR  BIT          NOT NULL,
  Name_TX      VARCHAR(100) NOT NULL,
  Note_TX      VARCHAR(255),
  PDefault_NR  BIT          NOT NULL,
  Price_NR     BIGINT       NOT NULL,
  State_NR     INTEGER      NOT NULL,
  StateInfo_TX VARCHAR(255),
  Service_ID   BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE BIZS_ServiceLog (
  id              BIGINT       NOT NULL AUTO_INCREMENT,
  CreateTime_DT   DATETIME     NOT NULL,
  Note_TX         VARCHAR(100),
  ServiceItems_TX VARCHAR(255) NOT NULL,
  Type_NR         INTEGER      NOT NULL,
  EntpUser_ID     BIGINT,
  Operator_ID     BIGINT       NOT NULL,
  PUser_ID        BIGINT,
  Related_ID      BIGINT,
  Service_ID      BIGINT       NOT NULL,
  UsedService_ID  BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE BIZS_SoftServiceDetail (
  id             BIGINT NOT NULL AUTO_INCREMENT,
  Menu_ID        BIGINT,
  MenuGroup_ID   BIGINT,
  MGroupRes_ID   BIGINT,
  Operation_ID   BIGINT,
  Service_ID     BIGINT,
  ServiceItem_ID BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE BIZS_UsedService (
  id                 BIGINT       NOT NULL AUTO_INCREMENT,
  Billing_YN         BIT          NOT NULL,
  BillingTime_DT     DATETIME     NOT NULL,
  CreateTime_DT      DATETIME     NOT NULL,
  DebtPeriod_NR      INTEGER      NOT NULL,
  LastBillingTime_DT DATETIME,
  MaxDebtPeriod_NR   INTEGER,
  PeriodDays_NR      INTEGER,
  PeriodType_NR      INTEGER,
  Price_NR           BIGINT       NOT NULL,
  PriceInfo_TX       VARCHAR(255),
  ServiceItems_TX    VARCHAR(255) NOT NULL,
  ServiceName_TX     VARCHAR(100),
  State_NR           INTEGER      NOT NULL,
  StateInfo_TX       VARCHAR(100),
  UpdateTime_DT      DATETIME,
  UseCount_NR        INTEGER,
  EntpUser_ID        BIGINT,
  Operator_ID        BIGINT       NOT NULL,
  PUser_ID           BIGINT,
  Service_ID         BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CALE_Calendar (
  id       BIGINT      NOT NULL AUTO_INCREMENT,
  Xml_TX   VARCHAR(255),
  Name_TX  VARCHAR(50) NOT NULL,
  Share_YN BIT         NOT NULL,
  Uid_TX   VARCHAR(50) NOT NULL,
  Owner_ID BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CALE_CalendarMap (
  id            BIGINT      NOT NULL AUTO_INCREMENT,
  Color_NR      INTEGER     NOT NULL,
  Name_TX       VARCHAR(50) NOT NULL,
  Permission_NR INTEGER     NOT NULL,
  Calendar_ID   BIGINT      NOT NULL,
  Principal_ID  BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CALE_Event (
  id          BIGINT       NOT NULL AUTO_INCREMENT,
  Alert_TX    VARCHAR(2000),
  AllDay_NR   BIT          NOT NULL,
  Desc_TX     VARCHAR(255),
  ETime_DT    DATETIME,
  ExpTime_DT  DATETIME,
  Location_TX VARCHAR(255),
  Reminder_NR BIGINT,
  Mode_NR     INTEGER      NOT NULL,
  BTime_DT    DATETIME,
  State_NR    INTEGER      NOT NULL,
  Summary_TX  VARCHAR(100) NOT NULL,
  Uid_TX      VARCHAR(50),
  Week_NR     TINYINT,
  Calendar_ID BIGINT       NOT NULL,
  Modifier_ID BIGINT       NOT NULL,
  Owner_ID    BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CALE_Permission (
  id           BIGINT  NOT NULL AUTO_INCREMENT,
  Power_NR     INTEGER NOT NULL,
  Calendar_ID  BIGINT  NOT NULL,
  Principal_ID BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE CMSArticle (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  title             VARCHAR(100),
  note              VARCHAR(500),
  urlName           VARCHAR(100),
  contents          LONGTEXT,
  category_id       BIGINT,
  category_label    VARCHAR(200),
  orderNo           BIGINT,
  type              BIGINT,
  mediaType         BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE CMSArticleCategory (
  id       BIGINT NOT NULL AUTO_INCREMENT,
  domainId BIGINT,
  parentId BIGINT,
  name     VARCHAR(100),
  note     VARCHAR(200),
  orderNo  DOUBLE PRECISION,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_Action (
  id              BIGINT      NOT NULL AUTO_INCREMENT,
  Bit_NR          INTEGER     NOT NULL,
  CreateTime_DT   DATETIME    NOT NULL,
  Name_TX         VARCHAR(50) NOT NULL,
  Note_TX         VARCHAR(255),
  UpdateTime_DT   DATETIME    NOT NULL,
  ResourceType_ID BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_Dict (
  id           BIGINT       NOT NULL AUTO_INCREMENT,
  Enable_YN    BIT          NOT NULL,
  Label_TX     VARCHAR(100) NOT NULL,
  NumberVal_NR BIGINT,
  OrderNo_NR   BIGINT       NOT NULL,
  StringVal_NR VARCHAR(255),
  Group_ID     BIGINT       NOT NULL,
  Domain_ID    BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_Domain (
  id                  BIGINT       NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  CreateTime_DT       DATETIME     NOT NULL,
  Name_TX             VARCHAR(50)  NOT NULL UNIQUE,
  Note_TX             VARCHAR(255),
  State_NR            INTEGER      NOT NULL,
  Storage_TX          VARCHAR(255) NOT NULL,
  Uid_TX              VARCHAR(50)  NOT NULL,
  UpdateTime_DT       DATETIME     NOT NULL,
  AdminRole_ID        BIGINT,
  Admin_ID            BIGINT,
  config_fk           BIGINT,
  MainGroup_ID        BIGINT,
  Parent_ID           BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_DomainCfg (
  id           BIGINT   NOT NULL AUTO_INCREMENT,
  ConfigXML_CB LONGTEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_DomainProp (
  id        BIGINT       NOT NULL AUTO_INCREMENT,
  Name_TX   VARCHAR(255) NOT NULL,
  Value_TX  LONGTEXT,
  Domain_ID BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_FormAttr (
  id                  BIGINT       NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  DictType_TX         VARCHAR(100),
  Encrypt_YN          BIT          NOT NULL,
  Label_TX            VARCHAR(100) NOT NULL,
  Name_TX             VARCHAR(100) NOT NULL,
  Type_NR             INTEGER      NOT NULL,
  Domain_ID           BIGINT       NOT NULL,
  Group_ID            BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_Group (
  id                  BIGINT       NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  CreateTime_DT       DATETIME     NOT NULL,
  HasChildren_YN      BIT          NOT NULL,
  MemberType_NR       INTEGER      NOT NULL,
  Name_TX             VARCHAR(100) NOT NULL,
  Note_TX             VARCHAR(255),
  PriValue_TX         VARCHAR(1024),
  UpdateTime_DT       DATETIME     NOT NULL,
  Domain_ID           BIGINT       NOT NULL,
  Owner_ID            BIGINT,
  Parent_ID           BIGINT,
  Resource_ID         BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_QueryDef (
  id            BIGINT       NOT NULL AUTO_INCREMENT,
  CreateTime_DT DATETIME     NOT NULL,
  Xml_TX        LONGTEXT     NOT NULL,
  Name_TX       VARCHAR(100) NOT NULL,
  Note_TX       VARCHAR(255),
  UID_TX        VARCHAR(100) NOT NULL,
  UpdateTime_DT DATETIME     NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_RecycledSequenceNo (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  SeqNo_NR    BIGINT NOT NULL,
  Timecode_NR BIGINT NOT NULL,
  TypeId_NR   BIGINT NOT NULL,
  Domain_ID   BIGINT NOT NULL,
  Sequence_ID BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_Resource (
  id                  BIGINT       NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  CreateTime_DT       DATETIME     NOT NULL,
  Name_TX             VARCHAR(255) NOT NULL,
  Node_TX             VARCHAR(255),
  PriValue_TX         VARCHAR(1024),
  UpdateTime_DT       DATETIME     NOT NULL,
  Domain_ID           BIGINT       NOT NULL,
  Group_ID            BIGINT       NOT NULL,
  Owner_ID            BIGINT,
  ResourceType_ID     BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_ResourceType (
  id                  BIGINT      NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  CreateTime_DT       DATETIME    NOT NULL,
  Name_TX             VARCHAR(50) NOT NULL,
  Note_TX             VARCHAR(255),
  UpdateTime_DT       DATETIME    NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_Sequence (
  id          BIGINT      NOT NULL AUTO_INCREMENT,
  LastTime_DT DATETIME    NOT NULL,
  NextSeq_NR  BIGINT      NOT NULL,
  Typecode_TX VARCHAR(50) NOT NULL,
  Domain_ID   BIGINT      NOT NULL,
  SeqType_ID  BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE CORE_SequenceType (
  id             BIGINT       NOT NULL AUTO_INCREMENT,
  Name_TX        VARCHAR(100) NOT NULL,
  Note_TX        VARCHAR(300),
  Recyclable_YN  BIT          NOT NULL,
  ResetPeriod_NR INTEGER      NOT NULL,
  ZeroStart_YN   BIT          NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE Department (
  id         BIGINT  NOT NULL AUTO_INCREMENT,
  domainId   BIGINT,
  ml_parent  BIGINT  NOT NULL,
  _ml_code_  BIGINT  NOT NULL,
  _ml_level_ INTEGER NOT NULL,
  groupId    BIGINT,
  roleId     BIGINT,
  name       VARCHAR(100),
  note       VARCHAR(500),
  PRIMARY KEY (id)
);

CREATE TABLE DomainCompany (
  id              BIGINT NOT NULL AUTO_INCREMENT,
  domainId        BIGINT,
  name            VARCHAR(100),
  domain_id       BIGINT,
  domainName      VARCHAR(100),
  parentName      VARCHAR(100),
  is_site_created BIT,
  company_uid     VARCHAR(50),
  xpt_site        VARCHAR(100),
  PRIMARY KEY (id)
);

CREATE TABLE Employee (
  id               BIGINT NOT NULL AUTO_INCREMENT,
  domainId         BIGINT,
  name             VARCHAR(30),
  email            VARCHAR(50),
  department_id    BIGINT,
  department_label VARCHAR(200),
  operator_id      BIGINT,
  operator_name    VARCHAR(100),
  loginId          VARCHAR(50),
  isLoginEnabled   BIT,
  birthday         DATETIME,
  msn              VARCHAR(100),
  qq               VARCHAR(50),
  sex              BIGINT,
  photo            VARCHAR(200),
  lastErrorTime    DATETIME,
  errorCount       BIGINT,
  isBlocked        BIT,
  PRIMARY KEY (id)
);

CREATE TABLE MSGMessage (
  id                 BIGINT NOT NULL AUTO_INCREMENT,
  domainId           BIGINT,
  msg_head           VARCHAR(100),
  msg_body           VARCHAR(2000),
  msg_kind           BIGINT,
  user_sender_id     BIGINT,
  user_sender_name   VARCHAR(100),
  user_receiver_id   BIGINT,
  user_receiver_name VARCHAR(100),
  sys_sender         VARCHAR(100),
  send_time          DATETIME,
  msg_status         BIGINT,
  msg_type           BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE MSG_ERecvMsg (
  id          BIGINT        NOT NULL AUTO_INCREMENT,
  Body_TX     VARCHAR(1024) NOT NULL,
  Error_TX    VARCHAR(100),
  Type_TX     VARCHAR(50)   NOT NULL,
  Receiver_TX VARCHAR(100)  NOT NULL,
  Sender_TX   VARCHAR(100)  NOT NULL,
  From_TX     VARCHAR(100)  NOT NULL,
  State_NR    INTEGER       NOT NULL,
  Title_TX    VARCHAR(100)  NOT NULL,
  Owner_ID    BIGINT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE MSG_ESendMsg (
  id          BIGINT        NOT NULL AUTO_INCREMENT,
  Body_TX     VARCHAR(1024) NOT NULL,
  Error_TX    VARCHAR(100),
  Type_TX     VARCHAR(50)   NOT NULL,
  Receiver_TX VARCHAR(100)  NOT NULL,
  Sender_TX   VARCHAR(100)  NOT NULL,
  From_TX     VARCHAR(100)  NOT NULL,
  State_NR    INTEGER       NOT NULL,
  Title_TX    VARCHAR(100)  NOT NULL,
  Owner_ID    BIGINT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE MSG_UMsg (
  id          BIGINT        NOT NULL AUTO_INCREMENT,
  Body_TX     VARCHAR(1024) NOT NULL,
  Error_TX    VARCHAR(100),
  Type_TX     VARCHAR(50)   NOT NULL,
  Receiver_TX VARCHAR(100)  NOT NULL,
  Sender_TX   VARCHAR(100)  NOT NULL,
  From_TX     VARCHAR(100)  NOT NULL,
  State_NR    INTEGER       NOT NULL,
  Title_TX    VARCHAR(100)  NOT NULL,
  Owner_ID    BIGINT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE MSG_USendMsg (
  id          BIGINT        NOT NULL AUTO_INCREMENT,
  Body_TX     VARCHAR(1024) NOT NULL,
  Error_TX    VARCHAR(100),
  Type_TX     VARCHAR(50)   NOT NULL,
  Receiver_TX VARCHAR(100)  NOT NULL,
  Sender_TX   VARCHAR(100)  NOT NULL,
  From_TX     VARCHAR(100)  NOT NULL,
  State_NR    INTEGER       NOT NULL,
  Title_TX    VARCHAR(100)  NOT NULL,
  Owner_ID    BIGINT        NOT NULL,
  RecvRole_ID BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE ReportFile (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  name              VARCHAR(100),
  report_uid        VARCHAR(100),
  condition_md5     VARCHAR(100),
  content_xml       LONGTEXT,
  folder_id         BIGINT,
  folder_label      VARCHAR(200),
  PRIMARY KEY (id)
);

CREATE TABLE ReportFolder (
  id                BIGINT NOT NULL AUTO_INCREMENT,
  FM_CreatePrinId   BIGINT,
  FM_CreatePrinName VARCHAR(100),
  FM_UpdatePrinId   BIGINT,
  FM_UpdatePrinName VARCHAR(100),
  FM_CreateTime     DATETIME,
  FM_UpdateTime     DATETIME,
  domainId          BIGINT,
  name              VARCHAR(100),
  parent_id         BIGINT,
  parent_label      VARCHAR(200),
  attributes        BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE SCRT_PagePermission (
  id        BIGINT        NOT NULL AUTO_INCREMENT,
  CtrlPT_TX VARCHAR(1024) NOT NULL,
  Group_ID  BIGINT        NOT NULL,
  Role_ID   BIGINT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE SCRT_Permission (
  id          BIGINT     NOT NULL AUTO_INCREMENT,
  Access_TX   VARCHAR(1) NOT NULL,
  Action_ID   BIGINT     NOT NULL,
  Resource_ID BIGINT     NOT NULL,
  Role_ID     BIGINT     NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE SCRT_Principal (
  id                  BIGINT       NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  CreateTime_DT       DATETIME     NOT NULL,
  EMail_TX            VARCHAR(100),
  LoginID_TX          VARCHAR(50)  NOT NULL,
  Name_TX             VARCHAR(255) NOT NULL,
  Note_TX             VARCHAR(255),
  Password_TX         VARCHAR(50)  NOT NULL,
  State_NR            INTEGER      NOT NULL,
  Uid_TX              VARCHAR(50)  NOT NULL,
  UpdateTime_DT       DATETIME     NOT NULL,
  Domain_ID           BIGINT       NOT NULL,
  Group_ID            BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE SCRT_PrincipalRole (
  Principal_ID BIGINT NOT NULL,
  Role_ID      BIGINT NOT NULL,
  PRIMARY KEY (Principal_ID, Role_ID)
);

CREATE TABLE SCRT_Role (
  id                  BIGINT       NOT NULL AUTO_INCREMENT,
  SystemPermission_NR INTEGER,
  CreateTime_DT       DATETIME,
  Name_TX             VARCHAR(150) NOT NULL,
  Note_TX             VARCHAR(255),
  Uid_TX              VARCHAR(100),
  UpdateTime_DT       DATETIME,
  Domain_ID           BIGINT       NOT NULL,
  Group_ID            BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE UserProfile (
  id               BIGINT NOT NULL AUTO_INCREMENT,
  domainId         BIGINT,
  owner_user_id    BIGINT,
  owner_user_name  VARCHAR(100),
  last_logout_time DATETIME,
  profile_type     VARCHAR(100),
  profile_content  VARCHAR(5000),
  PRIMARY KEY (id)
);

CREATE TABLE VERC_Version (
  id            BIGINT      NOT NULL AUTO_INCREMENT,
  CreateTime_DT DATETIME    NOT NULL,
  FileName_TX   VARCHAR(255),
  Note_TX       VARCHAR(255),
  VersionNo_TX  VARCHAR(50) NOT NULL,
  Author_ID     BIGINT      NOT NULL,
  Tree_ID       BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE VERC_VersionTree (
  id             BIGINT       NOT NULL AUTO_INCREMENT,
  State_NR       INTEGER      NOT NULL,
  StoragePath_TX VARCHAR(255) NOT NULL,
  UpdateTime_DT  DATETIME     NOT NULL,
  LastAuthor_ID  BIGINT       NOT NULL,
  Resource_ID    BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_HumanActivityLog (
  id                  BIGINT NOT NULL AUTO_INCREMENT,
  ExecutorTime_TM     DATETIME,
  ExecutorName_TX     VARCHAR(30),
  SubmitNote_TX       VARCHAR(1024),
  SubmitTargetName_TX VARCHAR(30),
  SubmitMode_TX       VARCHAR(30),
  TaskName_TX         VARCHAR(100),
  Executor_ID         BIGINT,
  ProcessInstance_ID  BIGINT,
  SubmitTarget_ID     BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_MsgItem (
  id               BIGINT       NOT NULL AUTO_INCREMENT,
  DomainID_NR      BIGINT,
  HandleType_NR    INTEGER      NOT NULL,
  Pattern_TX       VARCHAR(150) NOT NULL,
  MsgType_TX       VARCHAR(50)  NOT NULL,
  PendingTaskID_NR BIGINT,
  ProcessDefID_NR  BIGINT,
  Receiver_TX      VARCHAR(150) NOT NULL,
  TaskID_NR        BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_Node (
  nodetype          VARCHAR(31)  NOT NULL,
  id                BIGINT       NOT NULL AUTO_INCREMENT,
  Name_TX           VARCHAR(100) NOT NULL,
  Note_TX           VARCHAR(255),
  State_NR          INTEGER,
  UID_TX            VARCHAR(50)  NOT NULL,
  AfterScript_TX    VARCHAR(4096),
  BeforeScript_TX   VARCHAR(4096),
  TaskScript_TX     VARCHAR(4096),
  EnableRule_NR     INTEGER,
  FormParam_TX      VARCHAR(1024),
  FormUI_CB         LONGTEXT,
  FormUrl_TX        VARCHAR(512),
  WorkForm_TX       VARCHAR(255),
  AssignMethod_NR   INTEGER,
  AssignRule_NR     INTEGER,
  AssignScript_TX   VARCHAR(4096),
  FormAction_NR     INTEGER,
  FormState_NR      INTEGER,
  NotifyMode_NR     INTEGER,
  ReenterMode_NR    INTEGER,
  HeadPattern_TX    VARCHAR(255),
  MessageType_TX    VARCHAR(50),
  Receiver_TX       VARCHAR(100),
  MessageBody_TX    VARCHAR(512),
  MessageHead_TX    VARCHAR(128),
  Date_DT           DATETIME,
  Milli_NR          BIGINT,
  TrigerMode_NR     INTEGER,
  WeekDays_TX       TINYINT,
  Definition_ID     BIGINT       NOT NULL,
  FinishState_ID    BIGINT,
  StartState_ID     BIGINT,
  DepartmentGRP_ID  BIGINT,
  Role_ID           BIGINT,
  SubStartTask_ID   BIGINT,
  SubProcesssDef_ID BIGINT,
  Triger_ID         BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_PendingTask (
  id          BIGINT NOT NULL AUTO_INCREMENT,
  Data_TX     VARCHAR(1024),
  Instance_ID BIGINT NOT NULL,
  Task_ID     BIGINT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_ProcessDef (
  id            BIGINT       NOT NULL AUTO_INCREMENT,
  CreateTime_DT DATETIME     NOT NULL,
  DefState_NR   INTEGER,
  Name_TX       VARCHAR(100) NOT NULL,
  NoInstance_YN BIT,
  Note_TX       VARCHAR(255),
  UID_TX        VARCHAR(50)  NOT NULL,
  UpdateTime_DT DATETIME     NOT NULL,
  Variables_TX  VARCHAR(1024),
  WorkForm_TX   VARCHAR(2048),
  diagram_fk    BIGINT,
  Domain_ID     BIGINT       NOT NULL,
  Group_ID      BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_ProcessDiagram (
  id         BIGINT   NOT NULL AUTO_INCREMENT,
  Diagram_CB LONGTEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_ProcessInst (
  id                BIGINT       NOT NULL AUTO_INCREMENT,
  ActivateMode_NR   INTEGER      NOT NULL,
  CreateTime_DT     DATETIME     NOT NULL,
  CurrentState_NR   INTEGER      NOT NULL,
  Name_TX           VARCHAR(150) NOT NULL,
  StateInfo_TX      VARCHAR(255),
  UpdateTime_DT     DATETIME,
  Variables_TX      VARCHAR(1024),
  Activator_ID      BIGINT,
  Domain_ID         BIGINT       NOT NULL,
  EnterTask_ID      BIGINT,
  ParentProcesss_ID BIGINT,
  Definition_ID     BIGINT       NOT NULL,
  State_ID          BIGINT,
  StartTask_ID      BIGINT       NOT NULL,
  trace_fk          BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_ProcessTrace (
  id          BIGINT   NOT NULL AUTO_INCREMENT,
  TraceXML_CB LONGTEXT NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_RoundRobin (
  id           BIGINT  NOT NULL AUTO_INCREMENT,
  NextOrder_NR INTEGER NOT NULL,
  LastUser_ID  BIGINT  NOT NULL,
  task_fk      BIGINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_State (
  id            BIGINT       NOT NULL AUTO_INCREMENT,
  Name_TX       VARCHAR(100) NOT NULL,
  Note_TX       VARCHAR(255),
  Definition_ID BIGINT       NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_TimeItem (
  id               BIGINT  NOT NULL AUTO_INCREMENT,
  Date_DT          DATETIME,
  DomainID_NR      BIGINT,
  HandleType_NR    INTEGER NOT NULL,
  Milli_NR         BIGINT,
  PendingTaskID_NR BIGINT,
  ProcessDefID_NR  BIGINT,
  TaskID_NR        BIGINT,
  TrigerMode_NR    INTEGER NOT NULL,
  WeekDays_TX      TINYINT,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_Transition (
  id            BIGINT      NOT NULL AUTO_INCREMENT,
  Name_TX       VARCHAR(100),
  UID_TX        VARCHAR(50) NOT NULL,
  Definition_ID BIGINT      NOT NULL,
  Source_ID     BIGINT      NOT NULL,
  Target_ID     BIGINT      NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_WorkItem (
  id                BIGINT        NOT NULL AUTO_INCREMENT,
  Action_TX         VARCHAR(1024) NOT NULL,
  CreateTime_DT     DATETIME      NOT NULL,
  EntityID_NR       BIGINT,
  EntityUID_TX      VARCHAR(60),
  FinishTime_DT     DATETIME,
  Name_TX           VARCHAR(100)  NOT NULL,
  PrevWorkerName_TX VARCHAR(100),
  ProcessName_TX    VARCHAR(150)  NOT NULL,
  State_NR          INTEGER       NOT NULL,
  StateInfo_TX      VARCHAR(255),
  SubmitNote_TX     VARCHAR(1024),
  PendingTask_ID    BIGINT,
  PrevWorker_ID     BIGINT,
  Instance_ID       BIGINT        NOT NULL,
  Task_ID           BIGINT        NOT NULL,
  Worker_ID         BIGINT        NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE WKFL_WorkingLS (
  id        BIGINT  NOT NULL AUTO_INCREMENT,
  Size_NR   INTEGER NOT NULL,
  Worker_ID BIGINT,
  PRIMARY KEY (id)
);

ALTER TABLE ACCT_Account
ADD INDEX FK2B3E95E18FF9254A (Type_ID),
ADD CONSTRAINT FK2B3E95E18FF9254A
FOREIGN KEY (Type_ID)
REFERENCES ACCT_AccountType (id);

ALTER TABLE ACCT_Account
ADD INDEX FK2B3E95E114F36AB4 (Owner_ID),
ADD CONSTRAINT FK2B3E95E114F36AB4
FOREIGN KEY (Owner_ID)
REFERENCES CORE_Domain (id);

ALTER TABLE ACCT_AccountLog
ADD INDEX FK6824BDA3C40CB61D (Account_ID),
ADD CONSTRAINT FK6824BDA3C40CB61D
FOREIGN KEY (Account_ID)
REFERENCES ACCT_Account (id);

ALTER TABLE ACCT_AccountLog
ADD INDEX FK6824BDA314F36AB4 (Owner_ID),
ADD CONSTRAINT FK6824BDA314F36AB4
FOREIGN KEY (Owner_ID)
REFERENCES CORE_Domain (id);

CREATE INDEX opposite_account_type_idx ON AMS_AccountLog (opposite_account_type_id);

CREATE INDEX IDX_DOMAINID ON AMS_AccountLog (domainId);

CREATE INDEX account_type_idx ON AMS_AccountLog (account_type_id);

CREATE INDEX IDX_DOMAINID ON AMS_AccountRiskData (domainId);

CREATE INDEX IDX_DOMAINID ON AMS_AccountStatusLog (domainId);

CREATE INDEX account_type_idx ON AMS_AccountStatusLog (account_type_id);

CREATE INDEX currency_idx ON AMS_AccountType (currency_id);

CREATE INDEX IDX_DOMAINID ON AMS_AccountType (domainId);

CREATE INDEX IDX_DOMAINID ON AMS_Address (domainId);

CREATE INDEX IDX_CREATEPRINID ON AMS_AdjustAccount (FM_CreatePrinId);

CREATE INDEX IDX_WORKITEMID ON AMS_AdjustAccount (WF_WorkItemId);

CREATE INDEX operator_idx ON AMS_AdjustAccount (operator_id);

CREATE INDEX s_member_idx ON AMS_AdjustAccount (s_member_id;

CREATE INDEX auditor_idx ON AMS_AdjustAccount (auditor_id);

CREATE INDEX t_member_idx ON AMS_AdjustAccount (t_member_id)

CREATE INDEX IDX_PROCPRINID ON AMS_AdjustAccount (WF_ProcessorPrinId)

CREATE INDEX IDX_PROCESSID ON AMS_AdjustAccount (WF_ProcessId)

CREATE INDEX IDX_DOMAINID ON AMS_AdjustAccount (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_AdjustAccount (FM_UpdatePrinId)

CREATE INDEX account_type_idx ON AMS_AdjustAccount (account_type_id)

CREATE INDEX error_trade_handler_idx ON AMS_AdjustAccount (error_trade_handler_id)

CREATE INDEX IDX_DOMAINID ON AMS_AppCertificate (domainId)

CREATE INDEX pay_interface_idx ON AMS_AppPayAuth (pay_interface_id)

CREATE INDEX application_idx ON AMS_AppPayAuth (application_id)

CREATE INDEX IDX_DOMAINID ON AMS_AppPayAuth (domainId)

CREATE INDEX account_type_idx ON AMS_AppPayAuth (account_type_id)

CREATE INDEX application_idx ON AMS_AppTradeAuth (application_id)

CREATE INDEX IDX_DOMAINID ON AMS_AppTradeAuth (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_Application (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_Bank (domainId)

CREATE INDEX bank_idx ON AMS_BankCode (bank_id)

CREATE INDEX IDX_DOMAINID ON AMS_BankCode (domainId)

CREATE INDEX pay_interface_idx ON AMS_BillingFee (pay_interface_id)

CREATE INDEX application_idx ON AMS_BillingFee (application_id)

CREATE INDEX IDX_DOMAINID ON AMS_BillingFee (domainId)

CREATE INDEX account_type_idx ON AMS_BillingFee (account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_BillingLog (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_BillingParam (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_BillingReverseEntry (FM_CreatePrinId)

CREATE INDEX IDX_WORKITEMID ON AMS_BillingReverseEntry (WF_WorkItemId)

CREATE INDEX operator_idx ON AMS_BillingReverseEntry (operator_id)

CREATE INDEX auditor_idx ON AMS_BillingReverseEntry (auditor_id)

CREATE INDEX IDX_PROCPRINID ON AMS_BillingReverseEntry (WF_ProcessorPrinId)

CREATE INDEX IDX_PROCESSID ON AMS_BillingReverseEntry (WF_ProcessId)

CREATE INDEX IDX_DOMAINID ON AMS_BillingReverseEntry (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_BillingReverseEntry (FM_UpdatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_CaptchaCode (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_CardBin (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_CheckBalance (FM_CreatePrinId)

CREATE INDEX currency_idx ON AMS_CheckBalance (currency_id)

CREATE INDEX IDX_DOMAINID ON AMS_CheckBalance (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_CheckBalance (FM_UpdatePrinId)

CREATE INDEX IDX_CREATEPRINID ON AMS_CheckTrade (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_CheckTrade (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_CheckTrade (FM_UpdatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_Command (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_Currency (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_Developer (domainId)

CREATE INDEX application_idx ON AMS_EmailTemplate (application_id)

CREATE INDEX IDX_DOMAINID ON AMS_EmailTemplate (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_ErrorTradeHandle (FM_CreatePrinId)

CREATE INDEX IDX_WORKITEMID ON AMS_ErrorTradeHandle (WF_WorkItemId)

CREATE INDEX operator_idx ON AMS_ErrorTradeHandle (operator_id)

CREATE INDEX auditor_idx ON AMS_ErrorTradeHandle (auditor_id)

CREATE INDEX IDX_PROCPRINID ON AMS_ErrorTradeHandle (WF_ProcessorPrinId)

CREATE INDEX IDX_PROCESSID ON AMS_ErrorTradeHandle (WF_ProcessId)

CREATE INDEX IDX_DOMAINID ON AMS_ErrorTradeHandle (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_ErrorTradeHandle (FM_UpdatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_ErrorTradeLog (domainId)

CREATE INDEX member_idx ON AMS_Forum (member_id)

CREATE INDEX IDX_DOMAINID ON AMS_Forum (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_FreezeAdjust (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_FreezeAdjust (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_FreezeAdjust (FM_UpdatePrinId)

CREATE INDEX account_type_idx ON AMS_FreezeAdjust (account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_FreezeLog (domainId)

CREATE INDEX account_type_idx ON AMS_FreezeLog (account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_FreezeLogDetail (domainId)

CREATE INDEX account_type_idx ON AMS_FreezeLogDetail (account_type_id)

CREATE INDEX member_idx ON AMS_ManualWithdraw (member_id)

CREATE INDEX IDX_CREATEPRINID ON AMS_ManualWithdraw (FM_CreatePrinId)

CREATE INDEX IDX_WORKITEMID ON AMS_ManualWithdraw (WF_WorkItemId)

CREATE INDEX operator_idx ON AMS_ManualWithdraw (operator_id)

CREATE INDEX auditor_idx ON AMS_ManualWithdraw (auditor_id)

CREATE INDEX IDX_PROCPRINID ON AMS_ManualWithdraw (WF_ProcessorPrinId)

CREATE INDEX IDX_PROCESSID ON AMS_ManualWithdraw (WF_ProcessId)

CREATE INDEX IDX_DOMAINID ON AMS_ManualWithdraw (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_ManualWithdraw (FM_UpdatePrinId)

CREATE INDEX system_member_idx ON AMS_ManualWithdraw (system_member_id)

CREATE INDEX log_idx ON AMS_ManualWithdrawDetail (log_id)

CREATE INDEX IDX_DOMAINID ON AMS_ManualWithdrawDetail (domainId)

CREATE INDEX account_idx ON AMS_ManualWithdrawDetail (account_id)

CREATE INDEX account_type_idx ON AMS_ManualWithdrawDetail (account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_Member (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_MemberAccount (domainId)

CREATE INDEX account_type_idx ON AMS_MemberAccount (account_type_id)

CREATE INDEX member_idx ON AMS_MemberBank (member_id)

CREATE INDEX IDX_DOMAINID ON AMS_MemberBank (domainId)

CREATE INDEX account_type_idx ON AMS_MemberBank (account_type_id)

CREATE INDEX member_idx ON AMS_MemberInfoExts (member_id)

CREATE INDEX IDX_DOMAINID ON AMS_MemberInfoExts (domainId)

CREATE INDEX member_idx ON AMS_MemberOutAccount (member_id)

CREATE INDEX IDX_DOMAINID ON AMS_MemberOutAccount (domainId)

CREATE INDEX account_type_idx ON AMS_MemberOutAccount (account_type_id)

CREATE INDEX member_idx ON AMS_OperationLog (member_id)

CREATE INDEX IDX_DOMAINID ON AMS_OperationLog (domainId)

CREATE INDEX op_user_idx ON AMS_OperationLog (op_user_id)

CREATE INDEX IDX_DOMAINID ON AMS_Order (domainId)

CREATE INDEX target_account_type_idx ON AMS_OrderPayDetail (target_account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_OrderPayDetail (domainId)

CREATE INDEX account_type_idx ON AMS_OrderPayDetail (account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_OrderRefund (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_OrderSplitRule (domainId)

CREATE INDEX developer_idx ON AMS_OutAccountType (developer_id)

CREATE INDEX application_idx ON AMS_OutAccountType (application_id)

CREATE INDEX IDX_DOMAINID ON AMS_OutAccountType (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_PayChannel (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_PayChannel (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_PayChannel (FM_UpdatePrinId)

CREATE INDEX pay_channel_idx ON AMS_PayInterface (pay_channel_id)

CREATE INDEX IDX_DOMAINID ON AMS_PayInterface (domainId)

CREATE INDEX system_member_idx ON AMS_PayInterface (system_member_id)

CREATE INDEX bank_idx ON AMS_PayInterfaceBank (bank_id)

CREATE INDEX pay_interface_idx ON AMS_PayInterfaceBank (pay_interface_id)

CREATE INDEX IDX_DOMAINID ON AMS_PayInterfaceBank (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_PayLog (domainId)

CREATE INDEX account_type_idx ON AMS_PayLog (account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_Principal (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_RiskAttention (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_RiskAttentionLog (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_RiskBlackList (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_RiskBlackList (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_RiskBlackList (FM_UpdatePrinId)

CREATE INDEX IDX_CREATEPRINID ON AMS_RiskParam (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_RiskParam (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_RiskParam (FM_UpdatePrinId)

CREATE INDEX application_idx ON AMS_SMSTemplate (application_id)

CREATE INDEX IDX_DOMAINID ON AMS_SMSTemplate (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_SecurityLevel (domainId)

CREATE INDEX IDX_DOMAINID ON AMS_SecurityLevelLog (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_Setting (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON AMS_Setting (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_Setting (FM_UpdatePrinId)

CREATE INDEX member_idx ON AMS_SubAccount (member_id)

CREATE INDEX master_account_idx ON AMS_SubAccount (master_account_id)

CREATE INDEX IDX_DOMAINID ON AMS_SubAccount (domainId)

CREATE INDEX s_member_idx ON AMS_TradeLog (s_member_id)

CREATE INDEX t_account_type_idx ON AMS_TradeLog (t_account_type_id)

CREATE INDEX t_member_idx ON AMS_TradeLog (t_member_id)

CREATE INDEX IDX_DOMAINID ON AMS_TradeLog (domainId)

CREATE INDEX s_account_type_idx ON AMS_TradeLog (s_account_type_id)

CREATE INDEX IDX_DOMAINID ON AMS_TradeMonitorLog (domainId)

CREATE INDEX IDX_CREATEPRINID ON AMS_TradeRule (FM_CreatePrinId)

CREATE INDEX pay_interface_idx ON AMS_TradeRule (pay_interface_id)

CREATE INDEX IDX_DOMAINID ON AMS_TradeRule (domainId)

CREATE INDEX IDX_UPDATEPRINID ON AMS_TradeRule (FM_UpdatePrinId)

CREATE INDEX account_type_idx ON AMS_TradeRule (account_type_id)

ALTER TABLE BILL_AccountBill
ADD INDEX FK15D8937CD9771B2 (PayOperator_ID),
ADD CONSTRAINT FK15D8937CD9771B2
FOREIGN KEY (PayOperator_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BILL_AccountBill
ADD INDEX FK15D8937C39F29B5A (Operator_ID),
ADD CONSTRAINT FK15D8937C39F29B5A
FOREIGN KEY (Operator_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BILL_AccountBill
ADD INDEX FK15D8937C7EA7AE91 (Consumer_ID),
ADD CONSTRAINT FK15D8937C7EA7AE91
FOREIGN KEY (Consumer_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE BILL_AccountBill
ADD INDEX FK15D8937C94A560FB (Supplier_ID),
ADD CONSTRAINT FK15D8937C94A560FB
FOREIGN KEY (Supplier_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE BILL_BillDetail
ADD INDEX FK5440E2904DF133CE (Service_ID),
ADD CONSTRAINT FK5440E2904DF133CE
FOREIGN KEY (Service_ID)
REFERENCES BIZS_BizService (id)

ALTER TABLE BILL_BillDetail
ADD INDEX FK5440E290C3358F1C (Bill_ID),
ADD CONSTRAINT FK5440E290C3358F1C
FOREIGN KEY (Bill_ID)
REFERENCES BILL_AccountBill (id)

ALTER TABLE BILL_BillLog
ADD INDEX FKE45E196539F29B5A (Operator_ID),
ADD CONSTRAINT FKE45E196539F29B5A
FOREIGN KEY (Operator_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BILL_BillLog
ADD INDEX FKE45E1965C3358F1C (Bill_ID),
ADD CONSTRAINT FKE45E1965C3358F1C
FOREIGN KEY (Bill_ID)
REFERENCES BILL_AccountBill (id)

ALTER TABLE BIZS_BizService
ADD INDEX FK52239221451ED871 (Group_ID),
ADD CONSTRAINT FK52239221451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE BIZS_BizService
ADD INDEX FK5223922194A560FB (Supplier_ID),
ADD CONSTRAINT FK5223922194A560FB
FOREIGN KEY (Supplier_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE BIZS_ServiceItem
ADD INDEX FK4F00D7494DF133CE (Service_ID),
ADD CONSTRAINT FK4F00D7494DF133CE
FOREIGN KEY (Service_ID)
REFERENCES BIZS_BizService (id)

ALTER TABLE BIZS_ServiceLog
ADD INDEX FK3C5AE84E5BCA17 (EntpUser_ID),
ADD CONSTRAINT FK3C5AE84E5BCA17
FOREIGN KEY (EntpUser_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE BIZS_ServiceLog
ADD INDEX FK3C5AE84E90EBF74A (Related_ID),
ADD CONSTRAINT FK3C5AE84E90EBF74A
FOREIGN KEY (Related_ID)
REFERENCES BIZS_ServiceLog (id)

ALTER TABLE BIZS_ServiceLog
ADD INDEX FK3C5AE84E9BA05463 (PUser_ID),
ADD CONSTRAINT FK3C5AE84E9BA05463
FOREIGN KEY (PUser_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BIZS_ServiceLog
ADD INDEX FK3C5AE84E39F29B5A (Operator_ID),
ADD CONSTRAINT FK3C5AE84E39F29B5A
FOREIGN KEY (Operator_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BIZS_ServiceLog
ADD INDEX FK3C5AE84EACBF4EAE (UsedService_ID),
ADD CONSTRAINT FK3C5AE84EACBF4EAE
FOREIGN KEY (UsedService_ID)
REFERENCES BIZS_UsedService (id)

ALTER TABLE BIZS_ServiceLog
ADD INDEX FK3C5AE84E4DF133CE (Service_ID),
ADD CONSTRAINT FK3C5AE84E4DF133CE
FOREIGN KEY (Service_ID)
REFERENCES BIZS_BizService (id)

ALTER TABLE BIZS_SoftServiceDetail
ADD INDEX FKAA9567D65905992 (Menu_ID),
ADD CONSTRAINT FKAA9567D65905992
FOREIGN KEY (Menu_ID)
REFERENCES CORE_Resource (id)

ALTER TABLE BIZS_SoftServiceDetail
ADD INDEX FKAA9567DD4E3A763 (MGroupRes_ID),
ADD CONSTRAINT FKAA9567DD4E3A763
FOREIGN KEY (MGroupRes_ID)
REFERENCES CORE_Resource (id)

ALTER TABLE BIZS_SoftServiceDetail
ADD INDEX FKAA9567DEB9E410E (ServiceItem_ID),
ADD CONSTRAINT FKAA9567DEB9E410E
FOREIGN KEY (ServiceItem_ID)
REFERENCES BIZS_ServiceItem (id)

ALTER TABLE BIZS_SoftServiceDetail
ADD INDEX FKAA9567D4D21ED0 (MenuGroup_ID),
ADD CONSTRAINT FKAA9567D4D21ED0
FOREIGN KEY (MenuGroup_ID)
REFERENCES CORE_Group (id)

ALTER TABLE BIZS_SoftServiceDetail
ADD INDEX FKAA9567D1C943C8A (Operation_ID),
ADD CONSTRAINT FKAA9567D1C943C8A
FOREIGN KEY (Operation_ID)
REFERENCES CORE_Resource (id)

ALTER TABLE BIZS_SoftServiceDetail
ADD INDEX FKAA9567D5A9AF007 (Service_ID),
ADD CONSTRAINT FKAA9567D5A9AF007
FOREIGN KEY (Service_ID)
REFERENCES BIZS_BizService (id)

ALTER TABLE BIZS_UsedService
ADD INDEX FK77EBB8195BCA17 (EntpUser_ID),
ADD CONSTRAINT FK77EBB8195BCA17
FOREIGN KEY (EntpUser_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE BIZS_UsedService
ADD INDEX FK77EBB8199BA05463 (PUser_ID),
ADD CONSTRAINT FK77EBB8199BA05463
FOREIGN KEY (PUser_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BIZS_UsedService
ADD INDEX FK77EBB81939F29B5A (Operator_ID),
ADD CONSTRAINT FK77EBB81939F29B5A
FOREIGN KEY (Operator_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE BIZS_UsedService
ADD INDEX FK77EBB8194DF133CE (Service_ID),
ADD CONSTRAINT FK77EBB8194DF133CE
FOREIGN KEY (Service_ID)
REFERENCES BIZS_BizService (id)

ALTER TABLE CALE_Calendar
ADD INDEX FK6AB4D046950362EB (Owner_ID),
ADD CONSTRAINT FK6AB4D046950362EB
FOREIGN KEY (Owner_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CALE_CalendarMap
ADD INDEX FK877A2F366823AF90 (Principal_ID),
ADD CONSTRAINT FK877A2F366823AF90
FOREIGN KEY (Principal_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CALE_CalendarMap
ADD INDEX FK877A2F36201D49A2 (Calendar_ID),
ADD CONSTRAINT FK877A2F36201D49A2
FOREIGN KEY (Calendar_ID)
REFERENCES CALE_Calendar (id)

ALTER TABLE CALE_Event
ADD INDEX FK539FFA92201D49A2 (Calendar_ID),
ADD CONSTRAINT FK539FFA92201D49A2
FOREIGN KEY (Calendar_ID)
REFERENCES CALE_Calendar (id)

ALTER TABLE CALE_Event
ADD INDEX FK539FFA92D5DDB047 (Modifier_ID),
ADD CONSTRAINT FK539FFA92D5DDB047
FOREIGN KEY (Modifier_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CALE_Event
ADD INDEX FK539FFA92950362EB (Owner_ID),
ADD CONSTRAINT FK539FFA92950362EB
FOREIGN KEY (Owner_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CALE_Permission
ADD INDEX FK585A78D76823AF90 (Principal_ID),
ADD CONSTRAINT FK585A78D76823AF90
FOREIGN KEY (Principal_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CALE_Permission
ADD INDEX FK585A78D7201D49A2 (Calendar_ID),
ADD CONSTRAINT FK585A78D7201D49A2
FOREIGN KEY (Calendar_ID)
REFERENCES CALE_Calendar (id)

CREATE INDEX IDX_CREATEPRINID ON CMSArticle (FM_CreatePrinId)

CREATE INDEX category_idx ON CMSArticle (category_id)

CREATE INDEX IDX_DOMAINID ON CMSArticle (domainId)

CREATE INDEX IDX_UPDATEPRINID ON CMSArticle (FM_UpdatePrinId)

CREATE INDEX IDX_DOMAINID ON CMSArticleCategory (domainId)

ALTER TABLE CORE_Action
ADD INDEX FKEE25BEF64BEB5DE3 (ResourceType_ID),
ADD CONSTRAINT FKEE25BEF64BEB5DE3
FOREIGN KEY (ResourceType_ID)
REFERENCES CORE_ResourceType (id)

ALTER TABLE CORE_Dict
ADD INDEX FK493E7C76D8B80303 (Domain_ID),
ADD CONSTRAINT FK493E7C76D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_Dict
ADD INDEX FK493E7C76451ED871 (Group_ID),
ADD CONSTRAINT FK493E7C76451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE CORE_Domain
ADD INDEX FKF3EA1584DDF1152A (MainGroup_ID),
ADD CONSTRAINT FKF3EA1584DDF1152A
FOREIGN KEY (MainGroup_ID)
REFERENCES CORE_Group (id)

ALTER TABLE CORE_Domain
ADD INDEX FKF3EA1584F81E3CCF (Admin_ID),
ADD CONSTRAINT FKF3EA1584F81E3CCF
FOREIGN KEY (Admin_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CORE_Domain
ADD INDEX FKF3EA158433C8ED11 (config_fk),
ADD CONSTRAINT FKF3EA158433C8ED11
FOREIGN KEY (config_fk)
REFERENCES CORE_DomainCfg (id)

ALTER TABLE CORE_Domain
ADD INDEX FKF3EA15842D387D5D (Parent_ID),
ADD CONSTRAINT FKF3EA15842D387D5D
FOREIGN KEY (Parent_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_Domain
ADD INDEX FKF3EA158447B83175 (AdminRole_ID),
ADD CONSTRAINT FKF3EA158447B83175
FOREIGN KEY (AdminRole_ID)
REFERENCES SCRT_Role (id)

ALTER TABLE CORE_DomainProp
ADD INDEX FK1E41CB07D8B80303 (Domain_ID),
ADD CONSTRAINT FK1E41CB07D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_FormAttr
ADD INDEX FK7A9C6995D8B80303 (Domain_ID),
ADD CONSTRAINT FK7A9C6995D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_FormAttr
ADD INDEX FK7A9C6995451ED871 (Group_ID),
ADD CONSTRAINT FK7A9C6995451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE CORE_Group
ADD INDEX FKDEBF9DBFD8B80303 (Domain_ID),
ADD CONSTRAINT FKDEBF9DBFD8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_Group
ADD INDEX FKDEBF9DBF76807883 (Resource_ID),
ADD CONSTRAINT FKDEBF9DBF76807883
FOREIGN KEY (Resource_ID)
REFERENCES CORE_Resource (id)

ALTER TABLE CORE_Group
ADD INDEX FKDEBF9DBFA2571266 (Parent_ID),
ADD CONSTRAINT FKDEBF9DBFA2571266
FOREIGN KEY (Parent_ID)
REFERENCES CORE_Group (id)

ALTER TABLE CORE_Group
ADD INDEX FKDEBF9DBF950362EB (Owner_ID),
ADD CONSTRAINT FKDEBF9DBF950362EB
FOREIGN KEY (Owner_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CORE_RecycledSequenceNo
ADD INDEX FKCD6FA933D8B80303 (Domain_ID),
ADD CONSTRAINT FKCD6FA933D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_RecycledSequenceNo
ADD INDEX FKCD6FA93361B0F7A3 (Sequence_ID),
ADD CONSTRAINT FKCD6FA93361B0F7A3
FOREIGN KEY (Sequence_ID)
REFERENCES CORE_Sequence (id)

ALTER TABLE CORE_Resource
ADD INDEX FK4A14D4CE4BEB5DE3 (ResourceType_ID),
ADD CONSTRAINT FK4A14D4CE4BEB5DE3
FOREIGN KEY (ResourceType_ID)
REFERENCES CORE_ResourceType (id)

ALTER TABLE CORE_Resource
ADD INDEX FK4A14D4CED8B80303 (Domain_ID),
ADD CONSTRAINT FK4A14D4CED8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_Resource
ADD INDEX FK4A14D4CE451ED871 (Group_ID),
ADD CONSTRAINT FK4A14D4CE451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE CORE_Resource
ADD INDEX FK4A14D4CE950362EB (Owner_ID),
ADD CONSTRAINT FK4A14D4CE950362EB
FOREIGN KEY (Owner_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE CORE_Sequence
ADD INDEX FKAED98881D8B80303 (Domain_ID),
ADD CONSTRAINT FKAED98881D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE CORE_Sequence
ADD INDEX FKAED98881E6BB3AA5 (SeqType_ID),
ADD CONSTRAINT FKAED98881E6BB3AA5
FOREIGN KEY (SeqType_ID)
REFERENCES CORE_SequenceType (id)

CREATE INDEX IDX_DOMAINID ON Department (domainId)

CREATE INDEX IDX_DOMAINID ON DomainCompany (domainId)

CREATE INDEX operator_idx ON Employee (operator_id)

CREATE INDEX department_idx ON Employee (department_id)

CREATE INDEX IDX_DOMAINID ON Employee (domainId)

CREATE INDEX user_receiver_idx ON MSGMessage (user_receiver_id)

CREATE INDEX user_sender_idx ON MSGMessage (user_sender_id)

CREATE INDEX IDX_DOMAINID ON MSGMessage (domainId)

ALTER TABLE MSG_ERecvMsg
ADD INDEX FKFFCBB6D414F36AB4 (Owner_ID),
ADD CONSTRAINT FKFFCBB6D414F36AB4
FOREIGN KEY (Owner_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE MSG_ESendMsg
ADD INDEX FK3544C5F214F36AB4 (Owner_ID),
ADD CONSTRAINT FK3544C5F214F36AB4
FOREIGN KEY (Owner_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE MSG_UMsg
ADD INDEX FKE3EA550A950362EB (Owner_ID),
ADD CONSTRAINT FKE3EA550A950362EB
FOREIGN KEY (Owner_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE MSG_USendMsg
ADD INDEX FKB35793E2A50D92FE (RecvRole_ID),
ADD CONSTRAINT FKB35793E2A50D92FE
FOREIGN KEY (RecvRole_ID)
REFERENCES SCRT_Role (id)

ALTER TABLE MSG_USendMsg
ADD INDEX FKB35793E2950362EB (Owner_ID),
ADD CONSTRAINT FKB35793E2950362EB
FOREIGN KEY (Owner_ID)
REFERENCES SCRT_Principal (id)

CREATE INDEX IDX_CREATEPRINID ON ReportFile (FM_CreatePrinId)

CREATE INDEX folder_idx ON ReportFile (folder_id)

CREATE INDEX IDX_DOMAINID ON ReportFile (domainId)

CREATE INDEX IDX_UPDATEPRINID ON ReportFile (FM_UpdatePrinId)

CREATE INDEX IDX_CREATEPRINID ON ReportFolder (FM_CreatePrinId)

CREATE INDEX IDX_DOMAINID ON ReportFolder (domainId)

CREATE INDEX IDX_UPDATEPRINID ON ReportFolder (FM_UpdatePrinId)

CREATE INDEX parent_idx ON ReportFolder (parent_id)

ALTER TABLE SCRT_PagePermission
ADD INDEX FK76BE612BBDFABBA4 (Role_ID),
ADD CONSTRAINT FK76BE612BBDFABBA4
FOREIGN KEY (Role_ID)
REFERENCES SCRT_Role (id)

ALTER TABLE SCRT_PagePermission
ADD INDEX FK76BE612B451ED871 (Group_ID),
ADD CONSTRAINT FK76BE612B451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE SCRT_Permission
ADD INDEX FKC44787BCB7DF35C3 (Action_ID),
ADD CONSTRAINT FKC44787BCB7DF35C3
FOREIGN KEY (Action_ID)
REFERENCES CORE_Action (id)

ALTER TABLE SCRT_Permission
ADD INDEX FKC44787BCBDFABBA4 (Role_ID),
ADD CONSTRAINT FKC44787BCBDFABBA4
FOREIGN KEY (Role_ID)
REFERENCES SCRT_Role (id)

ALTER TABLE SCRT_Permission
ADD INDEX FKC44787BC76807883 (Resource_ID),
ADD CONSTRAINT FKC44787BC76807883
FOREIGN KEY (Resource_ID)
REFERENCES CORE_Resource (id)

ALTER TABLE SCRT_Principal
ADD INDEX FKABD63CA1D8B80303 (Domain_ID),
ADD CONSTRAINT FKABD63CA1D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE SCRT_Principal
ADD INDEX FKABD63CA1451ED871 (Group_ID),
ADD CONSTRAINT FKABD63CA1451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE SCRT_PrincipalRole
ADD INDEX FK275BF8B76823AF90 (Principal_ID),
ADD CONSTRAINT FK275BF8B76823AF90
FOREIGN KEY (Principal_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE SCRT_PrincipalRole
ADD INDEX FK275BF8B7BDFABBA4 (Role_ID),
ADD CONSTRAINT FK275BF8B7BDFABBA4
FOREIGN KEY (Role_ID)
REFERENCES SCRT_Role (id)

ALTER TABLE SCRT_Role
ADD INDEX FKC8967823D8B80303 (Domain_ID),
ADD CONSTRAINT FKC8967823D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE SCRT_Role
ADD INDEX FKC8967823451ED871 (Group_ID),
ADD CONSTRAINT FKC8967823451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

CREATE INDEX IDX_DOMAINID ON UserProfile (domainId)

CREATE INDEX owner_user_idx ON UserProfile (owner_user_id)

ALTER TABLE VERC_Version
ADD INDEX FKC97E609989D5A513 (Author_ID),
ADD CONSTRAINT FKC97E609989D5A513
FOREIGN KEY (Author_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE VERC_Version
ADD INDEX FKC97E609911F6149F (Tree_ID),
ADD CONSTRAINT FKC97E609911F6149F
FOREIGN KEY (Tree_ID)
REFERENCES VERC_VersionTree (id)

ALTER TABLE VERC_VersionTree
ADD INDEX FK2BE253D776807883 (Resource_ID),
ADD CONSTRAINT FK2BE253D776807883
FOREIGN KEY (Resource_ID)
REFERENCES CORE_Resource (id)

ALTER TABLE VERC_VersionTree
ADD INDEX FK2BE253D7A76F9B3D (LastAuthor_ID),
ADD CONSTRAINT FK2BE253D7A76F9B3D
FOREIGN KEY (LastAuthor_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_HumanActivityLog
ADD INDEX FK33C8A16DF1136A35 (SubmitTarget_ID),
ADD CONSTRAINT FK33C8A16DF1136A35
FOREIGN KEY (SubmitTarget_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_HumanActivityLog
ADD INDEX FK33C8A16D923BBE06 (ProcessInstance_ID),
ADD CONSTRAINT FK33C8A16D923BBE06
FOREIGN KEY (ProcessInstance_ID)
REFERENCES WKFL_ProcessInst (id)

ALTER TABLE WKFL_HumanActivityLog
ADD INDEX FK33C8A16D171A28CB (Executor_ID),
ADD CONSTRAINT FK33C8A16D171A28CB
FOREIGN KEY (Executor_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA7A07D5A1D (DepartmentGRP_ID),
ADD CONSTRAINT FKD03E3CA7A07D5A1D
FOREIGN KEY (DepartmentGRP_ID)
REFERENCES CORE_Group (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA738F501E8 (SubStartTask_ID),
ADD CONSTRAINT FKD03E3CA738F501E8
FOREIGN KEY (SubStartTask_ID)
REFERENCES WKFL_Node (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA738E0B5D7 (Definition_ID),
ADD CONSTRAINT FKD03E3CA738E0B5D7
FOREIGN KEY (Definition_ID)
REFERENCES WKFL_ProcessDef (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA777C9CA4E (Triger_ID),
ADD CONSTRAINT FKD03E3CA777C9CA4E
FOREIGN KEY (Triger_ID)
REFERENCES WKFL_TimeItem (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA786C40B5F (StartState_ID),
ADD CONSTRAINT FKD03E3CA786C40B5F
FOREIGN KEY (StartState_ID)
REFERENCES WKFL_State (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA7BDFABBA4 (Role_ID),
ADD CONSTRAINT FKD03E3CA7BDFABBA4
FOREIGN KEY (Role_ID)
REFERENCES SCRT_Role (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA7424A9509 (SubProcesssDef_ID),
ADD CONSTRAINT FKD03E3CA7424A9509
FOREIGN KEY (SubProcesssDef_ID)
REFERENCES WKFL_ProcessDef (id)

ALTER TABLE WKFL_Node
ADD INDEX FKD03E3CA7AE141290 (FinishState_ID),
ADD CONSTRAINT FKD03E3CA7AE141290
FOREIGN KEY (FinishState_ID)
REFERENCES WKFL_State (id)

ALTER TABLE WKFL_PendingTask
ADD INDEX FKE172D774F9747AC (Task_ID),
ADD CONSTRAINT FKE172D774F9747AC
FOREIGN KEY (Task_ID)
REFERENCES WKFL_Node (id)

ALTER TABLE WKFL_PendingTask
ADD INDEX FKE172D776280E7D5 (Instance_ID),
ADD CONSTRAINT FKE172D776280E7D5
FOREIGN KEY (Instance_ID)
REFERENCES WKFL_ProcessInst (id)

ALTER TABLE WKFL_ProcessDef
ADD INDEX FK6F5E1FBD8B80303 (Domain_ID),
ADD CONSTRAINT FK6F5E1FBD8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE WKFL_ProcessDef
ADD INDEX FK6F5E1FB451ED871 (Group_ID),
ADD CONSTRAINT FK6F5E1FB451ED871
FOREIGN KEY (Group_ID)
REFERENCES CORE_Group (id)

ALTER TABLE WKFL_ProcessDef
ADD INDEX FK6F5E1FB76919CA7 (diagram_fk),
ADD CONSTRAINT FK6F5E1FB76919CA7
FOREIGN KEY (diagram_fk)
REFERENCES WKFL_ProcessDiagram (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710A1004A5 (EnterTask_ID),
ADD CONSTRAINT FKD7C8C710A1004A5
FOREIGN KEY (EnterTask_ID)
REFERENCES WKFL_PendingTask (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710E45B310A (StartTask_ID),
ADD CONSTRAINT FKD7C8C710E45B310A
FOREIGN KEY (StartTask_ID)
REFERENCES WKFL_Node (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C71038E0B5D7 (Definition_ID),
ADD CONSTRAINT FKD7C8C71038E0B5D7
FOREIGN KEY (Definition_ID)
REFERENCES WKFL_ProcessDef (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710830AC8FD (State_ID),
ADD CONSTRAINT FKD7C8C710830AC8FD
FOREIGN KEY (State_ID)
REFERENCES WKFL_State (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710D8B80303 (Domain_ID),
ADD CONSTRAINT FKD7C8C710D8B80303
FOREIGN KEY (Domain_ID)
REFERENCES CORE_Domain (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710C21896E9 (trace_fk),
ADD CONSTRAINT FKD7C8C710C21896E9
FOREIGN KEY (trace_fk)
REFERENCES WKFL_ProcessTrace (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710C7829F3C (ParentProcesss_ID),
ADD CONSTRAINT FKD7C8C710C7829F3C
FOREIGN KEY (ParentProcesss_ID)
REFERENCES WKFL_ProcessInst (id)

ALTER TABLE WKFL_ProcessInst
ADD INDEX FKD7C8C710EB461749 (Activator_ID),
ADD CONSTRAINT FKD7C8C710EB461749
FOREIGN KEY (Activator_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_RoundRobin
ADD INDEX FKE45FCFA136322B7D (LastUser_ID),
ADD CONSTRAINT FKE45FCFA136322B7D
FOREIGN KEY (LastUser_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_RoundRobin
ADD INDEX FKE45FCFA1247EF93F (task_fk),
ADD CONSTRAINT FKE45FCFA1247EF93F
FOREIGN KEY (task_fk)
REFERENCES WKFL_Node (id)

ALTER TABLE WKFL_State
ADD INDEX FK37D20A8C38E0B5D7 (Definition_ID),
ADD CONSTRAINT FK37D20A8C38E0B5D7
FOREIGN KEY (Definition_ID)
REFERENCES WKFL_ProcessDef (id)

ALTER TABLE WKFL_Transition
ADD INDEX FK8707AC3A45F97DD3 (Source_ID),
ADD CONSTRAINT FK8707AC3A45F97DD3
FOREIGN KEY (Source_ID)
REFERENCES WKFL_Node (id)

ALTER TABLE WKFL_Transition
ADD INDEX FK8707AC3A38E0B5D7 (Definition_ID),
ADD CONSTRAINT FK8707AC3A38E0B5D7
FOREIGN KEY (Definition_ID)
REFERENCES WKFL_ProcessDef (id)

ALTER TABLE WKFL_Transition
ADD INDEX FK8707AC3A7A98789D (Target_ID),
ADD CONSTRAINT FK8707AC3A7A98789D
FOREIGN KEY (Target_ID)
REFERENCES WKFL_Node (id)

CREATE INDEX LISTIDX ON WKFL_WorkItem (Worker_ID, CreateTime_DT)

ALTER TABLE WKFL_WorkItem
ADD INDEX FK973779E973354A40 (Worker_ID),
ADD CONSTRAINT FK973779E973354A40
FOREIGN KEY (Worker_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_WorkItem
ADD INDEX FK973779E991B8716D (PrevWorker_ID),
ADD CONSTRAINT FK973779E991B8716D
FOREIGN KEY (PrevWorker_ID)
REFERENCES SCRT_Principal (id)

ALTER TABLE WKFL_WorkItem
ADD INDEX FK973779E94F9747AC (Task_ID),
ADD CONSTRAINT FK973779E94F9747AC
FOREIGN KEY (Task_ID)
REFERENCES WKFL_Node (id)

ALTER TABLE WKFL_WorkItem
ADD INDEX FK973779E9A9ACBD06 (PendingTask_ID),
ADD CONSTRAINT FK973779E9A9ACBD06
FOREIGN KEY (PendingTask_ID)
REFERENCES WKFL_PendingTask (id)

ALTER TABLE WKFL_WorkItem
ADD INDEX FK973779E96280E7D5 (Instance_ID),
ADD CONSTRAINT FK973779E96280E7D5
FOREIGN KEY (Instance_ID)
REFERENCES WKFL_ProcessInst (id)

ALTER TABLE WKFL_WorkingLS
ADD INDEX FK5177FCF373354A40 (Worker_ID),
ADD CONSTRAINT FK5177FCF373354A40
FOREIGN KEY (Worker_ID)
REFERENCES SCRT_Principal (id)
