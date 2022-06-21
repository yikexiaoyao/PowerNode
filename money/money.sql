/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : money

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 21/06/2022 13:10:38
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for b_bid_info
-- ----------------------------
DROP TABLE IF EXISTS `b_bid_info`;
CREATE TABLE `b_bid_info`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '投标记录ID',
  `loan_id` int NOT NULL COMMENT '产品ID',
  `uid` int NOT NULL COMMENT '用户ID',
  `bid_money` double NOT NULL COMMENT '投标金额',
  `bid_time` datetime NOT NULL COMMENT '投标时间',
  `bid_status` int NOT NULL COMMENT '投标状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3227 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '投资记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_bid_info
-- ----------------------------
INSERT INTO `b_bid_info` VALUES (3027, 1, 1, 1, '2017-08-20 15:04:54', 1);
INSERT INTO `b_bid_info` VALUES (3028, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3029, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3030, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3031, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3032, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3033, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3034, 1, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3035, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3036, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3037, 7, 1, 1, '2017-08-20 15:04:55', 1);
INSERT INTO `b_bid_info` VALUES (3038, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3039, 2, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3040, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3041, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3042, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3043, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3044, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3045, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3046, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3047, 2, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3048, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3049, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3050, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3051, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3052, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3053, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3054, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3055, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3056, 3, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3057, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3058, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3059, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3060, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3061, 2, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3062, 7, 1, 1, '2017-08-20 15:04:56', 1);
INSERT INTO `b_bid_info` VALUES (3063, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3064, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3065, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3066, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3067, 3, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3068, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3069, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3070, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3071, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3072, 4, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3073, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3074, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3075, 7, 1, 1, '2017-08-20 15:04:57', 1);
INSERT INTO `b_bid_info` VALUES (3076, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3077, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3078, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3079, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3080, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3081, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3082, 4, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3083, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3084, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3085, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3086, 6, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3087, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3088, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3089, 8, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3090, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3091, 6, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3092, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3093, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3094, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3095, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3096, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3097, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3098, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3099, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3100, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3101, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3102, 7, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3103, 9, 1, 1, '2017-08-20 15:04:58', 1);
INSERT INTO `b_bid_info` VALUES (3104, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3105, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3106, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3107, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3108, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3109, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3110, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3111, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3112, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3113, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3114, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3115, 8, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3116, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3117, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3118, 8, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3119, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3120, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3121, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3122, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3123, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3124, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3125, 6, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3126, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3127, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3128, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3129, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3130, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3131, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3132, 9, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3133, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3134, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3135, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3136, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3137, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3138, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3139, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3140, 5, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3141, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3142, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3143, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3144, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3145, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3146, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3147, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3148, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3149, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3150, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3151, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3152, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3153, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3154, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3155, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3156, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3157, 7, 1, 1, '2017-08-20 15:04:59', 1);
INSERT INTO `b_bid_info` VALUES (3158, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3159, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3160, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3161, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3162, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3163, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3164, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3165, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3166, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3167, 7, 1, 1, '2017-08-20 15:05:00', 1);
INSERT INTO `b_bid_info` VALUES (3168, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3169, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3170, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3171, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3172, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3173, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3174, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3175, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3176, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3177, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3178, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3179, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3180, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3181, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3182, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3183, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3184, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3185, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3186, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3187, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3188, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3189, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3190, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3191, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3192, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3193, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3194, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3195, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3196, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3197, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3198, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3199, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3200, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3201, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3202, 7, 1, 1, '2017-08-20 15:05:01', 1);
INSERT INTO `b_bid_info` VALUES (3203, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3204, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3205, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3206, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3207, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3208, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3209, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3210, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3211, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3212, 7, 1, 1, '2017-08-20 15:05:02', 1);
INSERT INTO `b_bid_info` VALUES (3213, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3214, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3215, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3216, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3217, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3218, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3219, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3220, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3221, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3222, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3223, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3224, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3225, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3226, 7, 1, 1, '2017-08-20 15:05:03', 1);
INSERT INTO `b_bid_info` VALUES (3227, 1, 1, 100, '2017-08-20 15:09:56', 1);

-- ----------------------------
-- Table structure for b_income_record
-- ----------------------------
DROP TABLE IF EXISTS `b_income_record`;
CREATE TABLE `b_income_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户ID',
  `loan_id` int NOT NULL COMMENT '产品ID',
  `bid_id` int NOT NULL COMMENT '投标记录ID',
  `bid_money` double NOT NULL COMMENT '投资金额',
  `income_date` date NOT NULL COMMENT '收益时间',
  `income_money` double NOT NULL COMMENT '收益金额',
  `income_status` int NOT NULL COMMENT '收益状态（0未返，1已返）',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 484 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '收益记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_income_record
-- ----------------------------
INSERT INTO `b_income_record` VALUES (203, 1, 6, 214, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (204, 1, 6, 215, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (205, 1, 6, 216, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (206, 1, 6, 217, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (207, 1, 6, 218, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (208, 1, 6, 219, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (209, 1, 6, 220, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (210, 1, 6, 221, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (211, 1, 6, 222, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (212, 1, 6, 223, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (213, 1, 6, 224, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (214, 1, 6, 225, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (215, 1, 6, 226, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (216, 1, 6, 227, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (217, 1, 6, 228, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (218, 1, 6, 229, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (219, 1, 6, 230, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (220, 1, 6, 231, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (221, 1, 6, 232, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (222, 1, 6, 233, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (223, 1, 6, 234, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (224, 1, 6, 235, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (225, 1, 6, 236, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (226, 1, 6, 237, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (227, 1, 6, 238, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (228, 1, 6, 239, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (229, 1, 6, 240, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (230, 1, 6, 241, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (231, 1, 6, 242, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (232, 1, 6, 243, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (233, 1, 6, 244, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (234, 1, 6, 245, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (235, 1, 6, 246, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (236, 1, 6, 247, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (237, 1, 6, 248, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (238, 1, 6, 249, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (239, 1, 6, 250, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (240, 1, 6, 251, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (241, 1, 6, 252, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (242, 1, 6, 253, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (243, 1, 6, 254, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (244, 1, 6, 255, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (245, 1, 6, 256, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (246, 1, 6, 257, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (247, 1, 6, 258, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (248, 1, 6, 259, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (249, 1, 6, 260, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (250, 1, 6, 261, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (251, 1, 6, 262, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (252, 1, 6, 263, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (253, 1, 6, 264, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (254, 1, 6, 265, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (255, 1, 6, 266, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (256, 1, 6, 267, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (257, 1, 6, 268, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (258, 1, 6, 269, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (259, 1, 6, 270, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (260, 1, 6, 271, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (261, 1, 6, 272, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (262, 1, 6, 273, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (263, 1, 6, 274, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (264, 1, 6, 275, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (265, 1, 6, 276, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (266, 1, 6, 277, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (267, 1, 6, 278, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (268, 1, 6, 279, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (269, 1, 6, 280, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (270, 1, 6, 281, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (271, 1, 6, 282, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (272, 1, 6, 283, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (273, 1, 6, 284, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (274, 1, 6, 285, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (275, 1, 6, 286, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (276, 1, 6, 287, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (277, 1, 6, 288, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (278, 1, 6, 289, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (279, 1, 6, 290, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (280, 1, 6, 291, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (281, 1, 6, 292, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (282, 1, 6, 293, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (283, 1, 6, 294, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (284, 1, 6, 295, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (285, 1, 6, 296, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (286, 1, 6, 297, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (287, 1, 6, 298, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (288, 1, 6, 299, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (289, 1, 6, 300, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (290, 1, 6, 301, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (291, 1, 6, 302, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (292, 1, 6, 303, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (293, 1, 6, 304, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (294, 1, 6, 305, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (295, 1, 6, 306, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (296, 1, 6, 307, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (297, 1, 6, 308, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (298, 1, 6, 309, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (299, 1, 6, 310, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (300, 2, 6, 311, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (301, 1, 6, 312, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (302, 1, 6, 313, 1, '2017-08-20', 0.01, 1);
INSERT INTO `b_income_record` VALUES (303, 1, 7, 3028, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (304, 1, 7, 3029, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (305, 1, 7, 3030, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (306, 1, 7, 3031, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (307, 1, 7, 3032, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (308, 1, 7, 3033, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (309, 1, 7, 3035, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (310, 1, 7, 3036, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (311, 1, 7, 3037, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (312, 1, 7, 3038, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (313, 1, 7, 3040, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (314, 1, 7, 3041, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (315, 1, 7, 3042, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (316, 1, 7, 3043, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (317, 1, 7, 3044, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (318, 1, 7, 3045, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (319, 1, 7, 3046, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (320, 1, 7, 3048, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (321, 1, 7, 3049, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (322, 1, 7, 3050, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (323, 1, 7, 3051, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (324, 1, 7, 3052, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (325, 1, 7, 3053, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (326, 1, 7, 3054, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (327, 1, 7, 3055, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (328, 1, 7, 3057, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (329, 1, 7, 3058, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (330, 1, 7, 3059, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (331, 1, 7, 3060, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (332, 1, 7, 3062, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (333, 1, 7, 3063, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (334, 1, 7, 3064, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (335, 1, 7, 3065, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (336, 1, 7, 3066, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (337, 1, 7, 3068, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (338, 1, 7, 3069, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (339, 1, 7, 3070, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (340, 1, 7, 3071, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (341, 1, 7, 3073, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (342, 1, 7, 3074, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (343, 1, 7, 3075, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (344, 1, 7, 3076, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (345, 1, 7, 3077, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (346, 1, 7, 3078, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (347, 1, 7, 3079, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (348, 1, 7, 3080, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (349, 1, 7, 3081, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (350, 1, 7, 3083, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (351, 1, 7, 3084, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (352, 1, 7, 3085, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (353, 1, 7, 3087, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (354, 1, 7, 3088, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (355, 1, 7, 3090, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (356, 1, 7, 3092, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (357, 1, 7, 3093, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (358, 1, 7, 3094, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (359, 1, 7, 3095, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (360, 1, 7, 3096, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (361, 1, 7, 3097, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (362, 1, 7, 3098, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (363, 1, 7, 3099, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (364, 1, 7, 3100, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (365, 1, 7, 3101, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (366, 1, 7, 3102, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (367, 1, 7, 3104, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (368, 1, 7, 3105, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (369, 1, 7, 3106, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (370, 1, 7, 3107, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (371, 1, 7, 3108, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (372, 1, 7, 3109, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (373, 1, 7, 3110, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (374, 1, 7, 3111, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (375, 1, 7, 3112, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (376, 1, 7, 3113, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (377, 1, 7, 3114, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (378, 1, 7, 3116, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (379, 1, 7, 3117, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (380, 1, 7, 3119, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (381, 1, 7, 3120, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (382, 1, 7, 3121, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (383, 1, 7, 3122, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (384, 1, 7, 3123, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (385, 1, 7, 3124, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (386, 1, 7, 3126, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (387, 1, 7, 3127, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (388, 1, 7, 3128, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (389, 1, 7, 3129, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (390, 1, 7, 3130, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (391, 1, 7, 3131, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (392, 1, 7, 3133, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (393, 1, 7, 3134, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (394, 1, 7, 3135, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (395, 1, 7, 3136, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (396, 1, 7, 3137, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (397, 1, 7, 3138, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (398, 1, 7, 3139, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (399, 1, 7, 3141, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (400, 1, 7, 3142, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (401, 1, 7, 3143, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (402, 1, 7, 3144, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (403, 1, 7, 3145, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (404, 1, 7, 3146, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (405, 1, 7, 3147, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (406, 1, 7, 3148, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (407, 1, 7, 3149, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (408, 1, 7, 3150, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (409, 1, 7, 3151, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (410, 1, 7, 3152, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (411, 1, 7, 3153, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (412, 1, 7, 3154, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (413, 1, 7, 3155, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (414, 1, 7, 3156, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (415, 1, 7, 3157, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (416, 1, 7, 3158, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (417, 1, 7, 3159, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (418, 1, 7, 3160, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (419, 1, 7, 3161, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (420, 1, 7, 3162, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (421, 1, 7, 3163, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (422, 1, 7, 3164, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (423, 1, 7, 3165, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (424, 1, 7, 3166, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (425, 1, 7, 3167, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (426, 1, 7, 3168, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (427, 1, 7, 3169, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (428, 1, 7, 3170, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (429, 1, 7, 3171, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (430, 1, 7, 3172, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (431, 1, 7, 3173, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (432, 1, 7, 3174, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (433, 1, 7, 3175, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (434, 1, 7, 3176, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (435, 1, 7, 3177, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (436, 1, 7, 3178, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (437, 1, 7, 3179, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (438, 1, 7, 3180, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (439, 1, 7, 3181, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (440, 1, 7, 3182, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (441, 1, 7, 3183, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (442, 1, 7, 3184, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (443, 1, 7, 3185, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (444, 1, 7, 3186, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (445, 1, 7, 3187, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (446, 1, 7, 3188, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (447, 1, 7, 3189, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (448, 1, 7, 3190, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (449, 1, 7, 3191, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (450, 1, 7, 3192, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (451, 1, 7, 3193, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (452, 1, 7, 3194, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (453, 1, 7, 3195, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (454, 1, 7, 3196, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (455, 1, 7, 3197, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (456, 1, 7, 3198, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (457, 1, 7, 3199, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (458, 1, 7, 3200, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (459, 1, 7, 3201, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (460, 1, 7, 3202, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (461, 1, 7, 3203, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (462, 1, 7, 3204, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (463, 1, 7, 3205, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (464, 1, 7, 3206, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (465, 1, 7, 3207, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (466, 1, 7, 3208, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (467, 1, 7, 3209, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (468, 1, 7, 3210, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (469, 1, 7, 3211, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (470, 1, 7, 3212, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (471, 1, 7, 3213, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (472, 1, 7, 3214, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (473, 1, 7, 3215, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (474, 1, 7, 3216, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (475, 1, 7, 3217, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (476, 1, 7, 3218, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (477, 1, 7, 3219, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (478, 1, 7, 3220, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (479, 1, 7, 3221, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (480, 1, 7, 3222, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (481, 1, 7, 3223, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (482, 1, 7, 3224, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (483, 1, 7, 3225, 1, '2017-08-26', 0.01, 0);
INSERT INTO `b_income_record` VALUES (484, 1, 7, 3226, 1, '2017-08-26', 0.01, 0);

-- ----------------------------
-- Table structure for b_loan_info
-- ----------------------------
DROP TABLE IF EXISTS `b_loan_info`;
CREATE TABLE `b_loan_info`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品名称',
  `rate` double NOT NULL COMMENT '产品利率',
  `cycle` int NOT NULL COMMENT '产品期限',
  `release_time` date NOT NULL COMMENT '产品发布时间',
  `product_type` int NOT NULL COMMENT '产品类型 0新手宝，1优选产品，2散标产品',
  `product_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品编号',
  `product_money` double NOT NULL COMMENT '产品金额',
  `left_product_money` double NOT NULL COMMENT '产品剩余可投金额',
  `bid_min_limit` double NOT NULL COMMENT '最低投资金额，即起投金额',
  `bid_max_limit` double NOT NULL COMMENT '最高投资金额，即最多能投多少金额',
  `product_status` int NOT NULL COMMENT '产品状态（0未满标，1已满标，2满标已生成收益计划）',
  `product_full_time` datetime NULL DEFAULT NULL COMMENT '产品投资满标时间',
  `product_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '产品描述',
  `version` int NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1310699 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '产品信息表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_loan_info
-- ----------------------------
INSERT INTO `b_loan_info` VALUES (1, '个人信用消费借款1', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 99500, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 4);
INSERT INTO `b_loan_info` VALUES (2, '个人信用消费借款2', 2.9, 6, '2017-07-24', 2, '20170722', 100000, 99696, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (3, '个人信用消费借款3', 4.9, 6, '2017-07-24', 2, '20170722', 100, 0, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `b_loan_info` VALUES (4, '个人信用消费借款4', 4.9, 6, '2017-07-24', 2, '20170722', 100, 0, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `b_loan_info` VALUES (6, '个人信用消费借款6', 4.9, 1, '2017-07-24', 2, '20170722', 100, 0, 100, 100, 2, '2017-07-16 16:54:06', '个人消费借款，信用良好，购车消费，精英人士', 100);
INSERT INTO `b_loan_info` VALUES (7, '个人信用消费借款7', 2.9, 6, '2017-07-24', 2, '20170722', 200, 0, 1, 100, 2, '2017-08-20 15:05:02', '个人消费借款，信用良好，购车消费，精英人士', 199);
INSERT INTO `b_loan_info` VALUES (8, '个人信用消费借款8', 1.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, '2017-02-19 11:12:12', '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (9, '个人信用消费借款9', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (13, '个人信用消费借款13', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (14, '个人信用消费借款14', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (15, '个人信用消费借款15', 3.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (16, '个人信用消费借款16', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (17, '个人信用消费借款17', 3.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (18, '个人信用消费借款18', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (19, '个人信用消费借款19', 1.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (20, '个人信用消费借款20', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (28, '个人信用消费借款28', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (29, '个人信用消费借款29', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (30, '个人信用消费借款30', 2.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (31, '个人信用消费借款31', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (32, '个人信用消费借款32', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (33, '个人信用消费借款33', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (34, '个人信用消费借款34', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (35, '个人信用消费借款35', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (36, '个人信用消费借款36', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (37, '个人信用消费借款37', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (38, '个人信用消费借款38', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (39, '个人信用消费借款39', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (40, '个人信用消费借款40', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (41, '个人信用消费借款41', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (42, '个人信用消费借款42', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (43, '个人信用消费借款43', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (59, '个人信用消费借款59', 4.9, 6, '2017-07-24', 2, '20170722', 100000, 100000, 100, 100, 0, NULL, '个人消费借款，信用良好，购车消费，精英人士', 0);
INSERT INTO `b_loan_info` VALUES (1310694, '满月宝', 5.6, 1, '2017-07-26', 1, '20170726', 1000000, 98600, 100, 100, 0, NULL, '短期信贷金融消费产品', 14);
INSERT INTO `b_loan_info` VALUES (1310695, '季度宝', 5.8, 1, '2017-07-26', 1, '20170726', 1000000, 99900, 100, 100, 0, NULL, '短期信贷金融消费产品', 1);
INSERT INTO `b_loan_info` VALUES (1310696, '双季宝', 6.5, 1, '2017-07-26', 1, '20170726', 1000000, 100000, 100, 100, 0, NULL, '短期信贷金融消费产品', 0);
INSERT INTO `b_loan_info` VALUES (1310697, '年度宝', 8.5, 1, '2017-07-26', 1, '20170726', 1000000, 100000, 100, 100, 0, NULL, '短期信贷金融消费产品', 0);
INSERT INTO `b_loan_info` VALUES (1310699, '新手宝', 15, 7, '2017-07-26', 0, '20170726', 100000, 99300, 100, 100, 0, NULL, '短期信贷金融消费产品', 2);

-- ----------------------------
-- Table structure for b_recharge_record
-- ----------------------------
DROP TABLE IF EXISTS `b_recharge_record`;
CREATE TABLE `b_recharge_record`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户id',
  `recharge_no` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值订单号',
  `recharge_status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值订单状态（0充值中，1充值成功，2充值失败）',
  `recharge_money` double NOT NULL COMMENT '充值金额',
  `recharge_time` datetime NOT NULL COMMENT '充值时间',
  `recharge_desc` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 103 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '充值记录表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of b_recharge_record
-- ----------------------------
INSERT INTO `b_recharge_record` VALUES (1, 1, '1501489834609', '0', 0.01, '2017-07-31 16:30:35', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (2, 1, '1501490635719', '0', 0.01, '2017-07-31 16:43:56', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (3, 1, '1501490823263', '1', 0.01, '2017-07-31 16:47:03', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (4, 1, '1501491112382', '1', 0.01, '2017-07-31 16:51:52', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (5, 1, '1501725717869', '0', 1.111, '2017-08-03 10:01:58', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (6, 1, '1501725981036', '0', 0.01, '2017-08-03 10:06:21', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (7, 1, '1501726137193', '0', 0.01, '2017-08-03 10:08:57', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (8, 1, '1501727489369', '0', 1.12122, '2017-08-03 10:31:29', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (9, 1, '1501728006875', '0', 0.01, '2017-08-03 10:40:07', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (10, 1, '1501728016965', '0', 0.01, '2017-08-03 10:40:17', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (11, 1, '1501728034093', '0', 0.01, '2017-08-03 10:40:34', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (12, 1, '1501728037262', '0', 0.01, '2017-08-03 10:40:37', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (13, 1, '1501728122258', '0', 1, '2017-08-03 10:42:02', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (14, 1, '1501728548630', '0', 0.01, '2017-08-03 10:49:09', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (15, 1, '1501728608962', '0', 0.01, '2017-08-03 10:50:09', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (16, 1, '1501728869884', '0', 0.01, '2017-08-03 10:54:30', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (17, 1, '1501728901531', '0', 0.01, '2017-08-03 10:55:02', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (18, 1, '1501728950112', '0', 0.01, '2017-08-03 10:55:50', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (19, 1, '1501728973824', '0', 0.01, '2017-08-03 10:56:14', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (20, 1, '1501729000664', '0', 0.01, '2017-08-03 10:56:41', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (21, 1, '1501729245978', '0', 0.01, '2017-08-03 11:00:46', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (22, 1, '1501729256515', '0', 0.01, '2017-08-03 11:00:57', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (23, 1, '1502021222705', '0', 0.01, '2017-08-06 20:07:03', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (24, 1, '1502023873391', '1', 0.01, '2017-08-06 20:51:13', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (25, 1, '1502024156914', '1', 0.01, '2017-08-06 20:55:57', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (26, 1, '1502448608243', '0', 0.1, '2017-08-11 18:50:08', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (27, 1, '1502448646236', '1', 0.01, '2017-08-11 18:50:46', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (28, 1, '1502449864723', '0', 0.01, '2017-08-11 19:11:05', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (29, 1, '1502500509727', '0', 0.01, '2017-08-12 09:15:10', '支付购买理财产品');
INSERT INTO `b_recharge_record` VALUES (30, 1, '1502519856863', '1', 0.01, '2017-08-12 14:37:37', '支付理财');
INSERT INTO `b_recharge_record` VALUES (31, 1, '1502866468501', '0', 0.01, '2017-08-16 14:54:29', '支付理财');
INSERT INTO `b_recharge_record` VALUES (32, 1, '1502868127518', '1', 0.01, '2017-08-16 15:22:08', '支付理财');
INSERT INTO `b_recharge_record` VALUES (33, 1, '1502868638430', '0', 0.01, '2017-08-16 15:30:38', '支付理财');
INSERT INTO `b_recharge_record` VALUES (34, 1, '1502868724312', '1', 0.01, '2017-08-16 15:32:04', '支付理财');
INSERT INTO `b_recharge_record` VALUES (35, 1, '1502872591807', '1', 0.01, '2017-08-16 16:36:32', '支付理财');
INSERT INTO `b_recharge_record` VALUES (36, 1, '1502873319830', '1', 0.01, '2017-08-16 16:48:40', '支付理财');
INSERT INTO `b_recharge_record` VALUES (37, 1, '1502873758936', '1', 0.01, '2017-08-16 16:55:59', '支付理财');
INSERT INTO `b_recharge_record` VALUES (38, 1, '1502874561626', '1', 0.01, '2017-08-16 17:09:22', '支付理财');
INSERT INTO `b_recharge_record` VALUES (39, 1, '1502874731033', '1', 0.01, '2017-08-16 17:12:11', '支付理财');
INSERT INTO `b_recharge_record` VALUES (40, 1, '1502879206156', '1', 0.01, '2017-08-16 18:26:46', '支付理财');
INSERT INTO `b_recharge_record` VALUES (41, 1, '1502880241719', '0', 0.01, '2017-08-16 18:44:02', '支付理财');
INSERT INTO `b_recharge_record` VALUES (42, 1, '1502880393830', '0', 0.01, '2017-08-16 18:46:34', '支付理财');
INSERT INTO `b_recharge_record` VALUES (43, 1, '201708181730337311', '0', 0.01, '2017-08-18 17:30:50', '支付理财');
INSERT INTO `b_recharge_record` VALUES (44, 1, '201708181741346741', '0', 0.01, '2017-08-18 17:42:34', '支付理财');
INSERT INTO `b_recharge_record` VALUES (45, 1, '201708181743079162', '0', 0.01, '2017-08-18 17:43:43', '支付理财');
INSERT INTO `b_recharge_record` VALUES (46, 1, '201708181743519043', '0', 0.01, '2017-08-18 17:43:58', '支付理财');
INSERT INTO `b_recharge_record` VALUES (47, 1, '201708181744042114', '0', 0.01, '2017-08-18 17:44:16', '支付理财');
INSERT INTO `b_recharge_record` VALUES (48, 1, '201708191759589502', '0', 0.01, '2017-08-19 17:59:59', '支付理财');
INSERT INTO `b_recharge_record` VALUES (49, 1, '201708191800535053', '0', 0.01, '2017-08-19 18:00:54', '支付理财');
INSERT INTO `b_recharge_record` VALUES (50, 1, '201708191801379264', '0', 0.01, '2017-08-19 18:01:38', '支付理财');
INSERT INTO `b_recharge_record` VALUES (51, 1, '201708201135431175', '0', 0.01, '2017-08-20 11:35:43', '支付理财');
INSERT INTO `b_recharge_record` VALUES (52, 1, '201708201136258596', '1', 0.01, '2017-08-20 11:36:26', '支付理财');
INSERT INTO `b_recharge_record` VALUES (90, 40, '2021122520473886140643', '1', 1000000, '2021-12-25 20:47:39', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (91, 40, '2021122520495433140557', '1', 8000, '2021-12-25 20:49:54', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (95, 40, '2021122714472596440546', '0', 80000, '2021-12-27 14:47:25', '微信充值');
INSERT INTO `b_recharge_record` VALUES (96, 40, '2021122714514928840663', '0', 80000, '2021-12-27 14:51:50', '微信充值');
INSERT INTO `b_recharge_record` VALUES (97, 40, '2021122714520144640678', '0', 10000, '2021-12-27 14:52:02', '微信充值');
INSERT INTO `b_recharge_record` VALUES (98, 40, '2021122714531620440272', '0', 10000, '2021-12-27 14:53:17', '微信充值');
INSERT INTO `b_recharge_record` VALUES (99, 40, '2021122714532585340516', '0', 10000, '2021-12-27 14:53:25', '微信充值');
INSERT INTO `b_recharge_record` VALUES (100, 40, '2021122714554999340113', '0', 10000, '2021-12-27 14:55:49', '微信充值');
INSERT INTO `b_recharge_record` VALUES (101, 40, '2021122714564452840773', '0', 10000, '2021-12-27 14:56:45', '微信充值');
INSERT INTO `b_recharge_record` VALUES (102, 40, '2021122714580512940772', '0', 10000, '2021-12-27 14:58:06', '支付宝充值');
INSERT INTO `b_recharge_record` VALUES (103, 40, '2021122714584793340296', '0', 10000, '2021-12-27 14:58:47', '微信充值');

-- ----------------------------
-- Table structure for u_finance_account
-- ----------------------------
DROP TABLE IF EXISTS `u_finance_account`;
CREATE TABLE `u_finance_account`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL COMMENT '用户ID',
  `available_money` double(15, 2) NOT NULL COMMENT '用户可用资金',
  `version` int NOT NULL COMMENT '版本号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户财务资金账户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_finance_account
-- ----------------------------
INSERT INTO `u_finance_account` VALUES (1, 1, 994948.61, 1);
INSERT INTO `u_finance_account` VALUES (2, 5, 999999800.00, 1);
INSERT INTO `u_finance_account` VALUES (4, 40, 1008888.00, 1);

-- ----------------------------
-- Table structure for u_user
-- ----------------------------
DROP TABLE IF EXISTS `u_user`;
CREATE TABLE `u_user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '注册手机号码',
  `login_password` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码，密码长度最大16位',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户姓名',
  `id_card` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户身份证号码',
  `add_time` datetime NULL DEFAULT NULL COMMENT '注册时间',
  `last_login_time` datetime NULL DEFAULT NULL COMMENT '最近登录时间',
  `header_image` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像文件路径',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of u_user
-- ----------------------------
INSERT INTO `u_user` VALUES (1, '13700000000', 'e10adc3949ba59abbe56e057f20f883e', '张无忌', '222222222222222222', '2017-08-20 12:40:28', '2017-08-20 15:09:49', NULL);
INSERT INTO `u_user` VALUES (5, '13700000001', '003d81296cbed643579b24d1cf6c907c', '张三丰', '111111111111111111', '2017-08-20 12:40:32', '2017-08-20 11:30:22', NULL);
INSERT INTO `u_user` VALUES (6, '13700000002', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (7, '13700000003', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (8, '13700000004', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (9, '13700000005', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (10, '13700000006', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (11, '13700000007', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (12, '13700000008', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (13, '13700000009', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (14, '13700000010', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (15, '13700000011', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (16, '13700000012', '003d81296cbed643579b24d1cf6c907c', '0', '0', NULL, NULL, NULL);
INSERT INTO `u_user` VALUES (17, '13700000013', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-03 15:05:25', '2017-08-03 15:05:25', NULL);
INSERT INTO `u_user` VALUES (18, '13700000014', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-03 15:06:46', '2017-08-03 15:06:46', NULL);
INSERT INTO `u_user` VALUES (19, '13700000015', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-07 10:02:27', '2017-08-07 10:02:27', NULL);
INSERT INTO `u_user` VALUES (21, '13700000016', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-07 10:13:34', '2017-08-07 10:13:34', NULL);
INSERT INTO `u_user` VALUES (22, '13700000017', '003d81296cbed643579b24d1cf6c907c', NULL, NULL, '2017-08-07 10:57:00', '2017-08-07 10:57:00', NULL);
INSERT INTO `u_user` VALUES (40, '13666666666', '71b596cb42ee254f7416043d184fc970', '王五', '321211111111111182', '2021-12-21 15:20:53', '2021-12-29 18:29:46', NULL);

SET FOREIGN_KEY_CHECKS = 1;
