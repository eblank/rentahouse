/**
 * 酒店筛选模块
 *
 * author: angtian
 * e-mail: angtian.fgm@taobao.com
 */
KISSY.add(function (S, Event, IO, Filter, FilterLocation, FilterPrice, FilterTemplate, FilterQuery) {

var filter_data = {};

/**
 * 酒店筛选模块构造函数
 *
 * @class FilterFilter
 * @constructor
 */
function HotelFilter() {
    this._init.apply(this, arguments);
}

return S.augment(HotelFilter, Event.Target, {

    /**
     * 筛选模块入口
     *
     * @method _init
     * @private
     */
    _init: function(id, data) {
        var self = this;

        //筛选数据
        self.data = data;
        //筛选容器
        self.nContainer = S.one(id);

        // 渲染酒店筛选结构
        self._renderUI();

        // 绑定事件
        self._bindUI();
    },

    /**
     * 渲染结构
     *
     * @method _renderUI()
     * @private
     */
    _renderUI: function() {
        var self = this;

        // 初始化位置筛选
        self._initFilterLocation({
            id: '#J_FilterLocation',
            type: 'radio',
            title: '位置'
        });

        self._initFilterPrice({
            id: '#J_FilterPrice',
            type: 'radio',
            title: '租金'
        });
        self._initFilterRoomNumber({
            id: '#J_FilterRoomNumber',
            type: 'radio',
            title: '卧室'
        });
        self._initFilterRentType({
            id: '#J_FilterRentType',
            type: 'radio',
            title: '方式'
        });
        self._initFilterToward({
            id: '#J_FilterToward',
            type: 'radio',
            title: '朝向'
        });
        self._initFilterDecoration({
            id: '#J_FilterDecoration',
            type: 'radio',
            title: '装修程度'
        });

        // 初始化已选列表
        self._initFilterQuery({
            id: '#J_FilterQuery',
            listId: '#J_FilterQueryList',
            title: '已选'
        });
    },

    /**
     * 绑定事件
     *
     * @method _bindUI()
     * @private
     */
    _bindUI: function() {
        var self = this;
        var minHeightClass = 'hotel-filter-list-min';

        // 包含位置数据
        if (self.filterLocation) {

            // 监听筛选条件改变事件
            self.filterLocation.on('select', function(e) {
                S.mix(filter_data, {location: e.option}, true);
                self._fire();
            });

            // 监听更多按钮点击事件
            var priceContainer = self.filterPrice.nContainer;
            priceContainer.delegate('click', '.J_FilterMore', function(e) {
                priceContainer.toggleClass(minHeightClass);
            });
        }

        // 包含价格数据
        if (self.filterPrice) {

            // 监听筛选条件改变事件
            self.filterPrice.on('select', function(e) {
                S.mix(filter_data, {price: e.option}, true);
                self._fire();
            });

            // 监听更多按钮点击事件
            var priceContainer = self.filterPrice.nContainer;
            priceContainer.delegate('click', '.J_FilterMore', function(e) {
                priceContainer.toggleClass(minHeightClass);
            });
        }

        //包含卧室数数据
        if (self.filterRoomNumber) {

            // 监听筛选条件改变事件
            self.filterRoomNumber.on('select', function(e) {
                S.mix(filter_data, {roomNumber: e.option}, true);
                self._fire();
            });

            // 监听更多按钮点击事件
            var roomNumberContainer = self.filterRoomNumber.nContainer;
            roomNumberContainer.delegate('click', '.J_FilterMore', function(e) {
                roomNumberContainer.toggleClass(minHeightClass);
            });
        }

        //包含出租方式数据
        if (self.filterRentType) {

            // 监听筛选条件改变事件
            self.filterRentType.on('select', function(e) {
                S.mix(filter_data, {rentType: e.option}, true);
                self._fire();
            });

            // 监听更多按钮点击事件
            var RentTypeContainer = self.filterRentType.nContainer;
            RentTypeContainer.delegate('click', '.J_FilterMore', function(e) {
                RentTypeContainer.toggleClass(minHeightClass);
            });
        }

        //包含房屋朝向数据
        if (self.filterToward) {

            // 监听筛选条件改变事件
            self.filterToward.on('select', function(e) {
                S.mix(filter_data, {toward: e.option}, true);
                self._fire();
            });

            // 监听更多按钮点击事件
            var towardContainer = self.filterToward.nContainer;
            towardContainer.delegate('click', '.J_FilterMore', function(e) {
                towardContainer.toggleClass(minHeightClass);
            });
        }

        //包含房屋朝向数据
        if (self.filterDecoration) {

            // 监听筛选条件改变事件
            self.filterDecoration.on('select', function(e) {
                S.mix(filter_data, {decoration: e.option}, true);
                self._fire();
            });

            // 监听更多按钮点击事件
            var decorationContainer = self.filterDecoration.nContainer;
            decorationContainer.delegate('click', '.J_FilterMore', function(e) {
                decorationContainer.toggleClass(minHeightClass);
            });
        }

        // 筛选条件改变事件
        self.on('filter:change', function(e) {

            // 更新已选列表
            self.filterQuery.update(self._formatData(e.data));

            var param = self._getParam(e.data);

             console.log('请求接口参数:', param);
        });

        // 删除已选条件事件
        if (self.filterQuery) {
            self.filterQuery.on('remove', function(e) {
                var type = e.data.type;
                var value = e.data.value;

                switch(type) {
                    case 'location':
                        self.filterLocation.remove();
                        S.mix(filter_data, {location: self.filterLocation.getValue()}, true);
                        break;
                    case 'price':
                        self.filterPrice.remove();
                        S.mix(filter_data, {price: self.filterPrice.getValue()}, true);
                        break;
                    case 'roomNumber':
                        self.filterRoomNumber.remove(value);
                        S.mix(filter_data, {roomNumber: self.filterRoomNumber.getValue()}, true);
                        break;
                    case 'rentType':
                        self.filterRentType.remove(value);
                        S.mix(filter_data, {rentType: self.filterRentType.getValue()}, true);
                        break;
                    case 'toward':
                        self.filterToward.remove(value);
                        S.mix(filter_data, {toward: self.filterToward.getValue()}, true);
                        break;
                    case 'decoration':
                        self.filterDecoration.remove(value);
                        S.mix(filter_data, {decoration: self.filterDecoration.getValue()}, true);
                        break;

                }

                if (!type) {
                    self.filterLocation.remove();
                    self.filterPrice.remove();
                    self.filterRoomNumber.remove();
                    self.filterRentType.remove();
                    self.filterToward.remove();
                    self.filterDecoration.remove();
                    filter_data = {};
                }

                self._fire();
            });
        }
    },

    /**
     * 初始化位置筛选
     *
     * @method _initFilterLocation
     * @param  {Object} cfg 配置参数
     * @private
     */
    _initFilterLocation: function(cfg) {
        var self = this;

        var id    = cfg.id;
        var type  = cfg.type;
        var title = cfg.title;
        var data  = self.data.queryLocat;
        var query = self.data.query;

        if (!self._checkData(data)) {
            return;
        }

        self.nContainer.append(FilterTemplate.location({
            id: id,
            type: type,
            data: data,
            title: title
        }));

        self.filterLocation = new FilterLocation({
            id: id,
            type: type
        });

        // 接口参数: 位置经度
        var lng = query.pByRadiusLng;

        // 接口参数: 位置纬度
        var lat = query.pByRadiusLat;

        // 选中已选择的位置
        self.filterLocation.select(lng + ',' + lat);

        // 设置位置数据
        S.mix(filter_data, {location: self.filterLocation.getValue()}, true);
    },

    /**
     * 初始化价格筛选
     *
     * @method _initFilterPrice
     * @param  {Object} cfg 配置参数
     * @private
     */
    _initFilterPrice: function(cfg) {
        var self = this;

        var id    = cfg.id;
        var type  = cfg.type;
        var title = cfg.title;
        var data  = self.data.queryPrice;
        var query = self.data.query;

        if (!self._checkData(data)) {
            return;
        }

        self.nContainer.append(FilterTemplate.price({
            id: id,
            type: type,
            data: data,
            title: title
        }));

        self.filterPrice = new FilterPrice({
            id: id,
            type: type
        });

        // 判断是否显示更多按钮
        if (self.filterPrice.nContainer.height() >36) {
            self.filterPrice.nContainer.addClass('filter-list-has-more hotel-filter-list-min');
        }

        // 接口参数: 价格区间
        var price = query.priceRange;

        // 接口参数: 最低价
        var lowPrice = query.lowPrice;

        // 接口参数: 最高价
        var highPrice = query.highPrice;

        // 选中已选择的价格区间
        self.filterPrice.select(price, lowPrice, highPrice);

        // 设置价格数据
        S.mix(filter_data, {price: self.filterPrice.getValue()}, true);
    },

    /**
     * 初始化卧室数
     *
     * @param cfg {Object} 配置参数
     * @private
     */
    _initFilterRoomNumber: function(cfg) {
        var self = this;

        var id    = cfg.id;
        var type  = cfg.type;
        var title = cfg.title;
        var data  = self.data.queryRoomNumber;
        var query = self.data.query;

        if (!self._checkData(data)) {
            return;
        }

        self.nContainer.append(FilterTemplate.normal({
            id: id,
            type: type,
            data: data,
            title: title
        }));

        self.filterRoomNumber = new Filter({
            id: id,
            type: type
        });

        // 判断是否显示更多按钮
        if (self.filterRoomNumber.nContainer.height() >36) {
            self.filterRoomNumber.nContainer.addClass('filter-list-has-more hotel-filter-list-min');
        }

        // 可使用的筛选条件
        var roomNumberActive = self.data.activeOption.roomNumber;
        self.filterRoomNumber.disabled();
        self.filterRoomNumber.enabled(roomNumberActive);

        // 接口参数: 已选择的房间数
        var value = query.dangcis;

        // 选中已选择的房间数
        self.filterRoomNumber.select(value);

        // 设置房间数数据
        S.mix(filter_data, {roomNumber: self.filterRoomNumber.getValue()}, true);
    },

    /**
     * 初始出租方式
     *
     * @param cfg {Object} 配置参数
     * @private
     */
    _initFilterRentType: function(cfg) {
        var self = this;

        var id    = cfg.id;
        var type  = cfg.type;
        var title = cfg.title;
        var data  = self.data.queryType;
        var query = self.data.query;

        if (!self._checkData(data)) {
            return;
        }

        self.nContainer.append(FilterTemplate.normal({
            id: id,
            type: type,
            data: data,
            title: title
        }));

        self.filterRentType = new Filter({
            id: id,
            type: type
        });

        // 判断是否显示更多按钮
        if (self.filterRentType.nContainer.height() >36) {
            self.filterRentType.nContainer.addClass('filter-list-has-more hotel-filter-list-min');
        }

        // 可使用的筛选条件
        var rentTypeActive = self.data.activeOption.rentType;
        self.filterRentType.disabled();
        self.filterRentType.enabled(rentTypeActive);

        // 接口参数: 已选择的出租方式
        var value = query.dangcis;

        // 选中已选择的出租方式
        self.filterRentType.select(value);

        // 设置出租方式数据
        S.mix(filter_data, {rentType: self.filterRentType.getValue()}, true);
    },

    /**
     * 初始朝向
     *
     * @param cfg {Object} 配置参数
     * @private
     */
    _initFilterToward: function(cfg) {
        var self = this;

        var id    = cfg.id;
        var type  = cfg.type;
        var title = cfg.title;
        var data  = self.data.queryToward;
        var query = self.data.query;

        if (!self._checkData(data)) {
            return;
        }

        self.nContainer.append(FilterTemplate.normal({
            id: id,
            type: type,
            data: data,
            title: title
        }));

        self.filterToward = new Filter({
            id: id,
            type: type
        });

        // 判断是否显示更多按钮
        if (self.filterToward.nContainer.height() >36) {
            self.filterToward.nContainer.addClass('filter-list-has-more hotel-filter-list-min');
        }

        // 可使用的筛选条件
        var towardActive = self.data.activeOption.toward;
        self.filterToward.disabled();
        self.filterToward.enabled(towardActive);

        // 接口参数: 已选择的出租方式
        var value = query.dangcis;

        // 选中已选择的出租方式
        self.filterToward.select(value);

        // 设置出租方式数据
        S.mix(filter_data, {toward: self.filterToward.getValue()}, true);
    },

    /**
     * 初始化装修程度
     *
     * @param cfg {Object} 配置参数
     * @private
     */
    _initFilterDecoration: function(cfg) {
        var self = this;

        var id    = cfg.id;
        var type  = cfg.type;
        var title = cfg.title;
        var data  = self.data.queryDecoration;
        var query = self.data.query;

        if (!self._checkData(data)) {
            return;
        }

        self.nContainer.append(FilterTemplate.normal({
            id: id,
            type: type,
            data: data,
            title: title
        }));

        self.filterDecoration = new Filter({
            id: id,
            type: type
        });

        // 判断是否显示更多按钮
        if (self.filterDecoration.nContainer.height() >36) {
            self.filterDecoration.nContainer.addClass('filter-list-has-more hotel-filter-list-min');
        }

        // 可使用的筛选条件
        var decorationActive = self.data.activeOption.decoration;
        self.filterDecoration.disabled();
        self.filterDecoration.enabled(decorationActive);

        // 接口参数: 已选择的出租方式
        var value = query.dangcis;

        // 选中已选择的出租方式
        self.filterDecoration.select(value);

        // 设置出租方式数据
        S.mix(filter_data, {decoration: self.filterDecoration.getValue()}, true);
    },

    /**
     * 初始化已选区域
     *
     * @method _initFilterQuery
     * @param  {Object} cfg 配置参数
     * @private
     */
    _initFilterQuery: function(cfg) {
        var self = this;

        var id = cfg.id;
        var listId = cfg.listId;
        var title = cfg.title;

        self.nContainer.append(FilterTemplate.query({
            id: id,
            listId: listId,
            title: title
        }));

        self.filterQuery = new FilterQuery({
            id: id,
            listId: listId
        });

        // 更新已选列表，不请求接口
        self.filterQuery.update(self._formatData(filter_data));
    },

    /**
     * 触发数据变化事件方法
     *
     * @method _fire
     * @private
     */
    _fire: function() {
        var self = this;

        self.fire('filter:change', {data: filter_data});
    },

    /**
     * 检验数据有效性
     *
     * @method _checkData
     * @param  {Array} data 待检验的数据
     * @return {Boolean}
     * @private
     */
    _checkData: function(data) {
        return S.isArray(data) && data.length > 0;
    },

    /**
     * 格式化已选条件数据
     *
     * @method _formatQueryData
     * @private
     */
    _formatData: function(data) {
        var self = this;

        var result = [];

        S.each(data, function(o, k) {
            if (!o.value || !o.text) {
                return;
            }
            if (S.isArray(o.value)) {
                S.each(o.value, function(v, i) {
                    result.push({
                        type: k,
                        text: o.text[i],
                        value: v
                    });
                });
                return;
            }
            result.push({
                type: k,
                text: o.text,
                value: o.value
            });
        });

        return result;
    },

    /**
     * 获取请求参数
     *
     * @method _getParam
     * @return {Object} 返回参数对象
     * @private
     */
    _getParam: function(data) {
        var self = this;
        var query = self.data.query;

        // 星级参数

        // 返回merge后的query对象
        return S.merge(query, {
            _input_charset: 'utf-8'
        });
    }

});

}, {requires:['event', 'ajax', 'gallery/filter/1.1/', './filter-location', './filter-price', './filter-template', './filter-query']});